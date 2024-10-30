package ejemplosPC2023;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nestor.diaz
 */
public class Comedor {
    private int cantPlatos, cantMascotas, perroEsp, perroCom, gatoEsp, gatoCom, ocupacion;
    Semaphore semGato, semPerro, mutex, semPlatos;
    private boolean ban, primerVuelta;

    public Comedor(int Platos, int unaCantMascota) {
        cantPlatos = Platos;
        cantMascotas = unaCantMascota;
        perroEsp = 0;
        perroCom = 0;
        gatoEsp = 0;
        gatoCom = 0;
        ocupacion = cantMascotas;
        ban = true;
        primerVuelta = true;
        semPlatos = new Semaphore(cantPlatos);
        semGato = new Semaphore(0);
        semPerro = new Semaphore(0);
        mutex = new Semaphore(1);
    }// Fin contructor

    // -------------------------------------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------------
    public void entraPerro() {
        try {

            if (ban) {
                mutex.acquire();
                ban = false;
                mutex.release();
                System.out.println("El primero que entro fue un PERRO");
                this.semPerro.release(this.cantMascotas);// Habilitar la entrada de N perros
                System.out.println("Se permiten " + cantMascotas + " perros comer!");
            } // Fin If
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin metodo entraPerro
     // -------------------------------------------------------------------------------------------------------------

    public void SalaEsperaPerro() {
        // El metodo deja entrar a la sala de espera a los perros y lleva la cuenta
        // de cuantos hay esperando.

        try {
            mutex.acquire();
            this.perroEsp++;
            mutex.release();
            this.semPerro.acquire();// Lo toma para habilitar la entrada de perros
            System.out.println("Hay: " + perroEsp + " Perros esperando");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin metodo SalaEsperaPerro
     // -------------------------------------------------------------------------------------------------------------

    public void ComePerro() {
        // El metodo deja entrar a comer y descuenta un perro de los que esperan.
        try {
            this.semPlatos.acquire();
            mutex.acquire();
            this.perroCom++;
            System.out.println("El PERRO " + Thread.currentThread().getName()
                    + " esta COMIENDO");
            this.perroEsp--;
            mutex.release();
            System.out.println("Hay: " + perroEsp + " perros esperando y "
                    + gatoEsp + " gatos esperando!");

        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        } // Fin TryCatch

    }// Fin metodo ComePerro

    public void SalePerro() {
        // El metodo permite que salga el perro, lleva la cuenta de cuantos comieron
        // y decide a quien le da el permiso para ingresar a comer.
        try {
            mutex.acquire();
            System.out.println("El PERRO " + Thread.currentThread().getName()
                    + " DEJO DE COMER Y SALE");
            this.semPlatos.release();
            ocupacion--;
            mutex.release();
            if ((this.ocupacion == (this.cantMascotas - this.perroCom)) && (this.perroEsp == 0) && primerVuelta) {
                semPerro.acquire(ocupacion);
                primerVuelta = false;
                if (this.gatoEsp > 0) {
                    mutex.acquire();
                    gatoCom = 0;
                    mutex.release();

                    System.out.println("--------------------------CAMBIO DE TURNO, LE TOCA A LOS GATOS");

                    if (this.gatoEsp < this.cantMascotas) {
                        this.semGato.release(this.gatoEsp);// Deja entrar solo los Gatos que estan esperando
                        mutex.acquire();
                        ocupacion = this.gatoEsp;
                        mutex.release();
                    } else {
                        this.semGato.release(this.cantMascotas);// Deja entrar a N Gatos
                        mutex.acquire();
                        ocupacion = this.cantMascotas;
                        mutex.release();
                    }
                } else {
                    mutex.acquire();
                    ocupacion = cantMascotas;
                    ban = true;
                    perroCom = 0;
                    gatoCom = 0;
                    System.out.println("SE REINICIARA EL COMEDOR, SALIO POR PERRO en la OPCION 2 ");
                    mutex.release();
                } // Fin If de gatos esperando
                System.out.println("ENTRO UNA SOLA VEZ, modificado");
            }

            // System.out.println("La ocupacion es de " + ocupacion);
            if (ocupacion == 0) {
                primerVuelta = false;
                System.out.println("Hay: " + perroEsp + " perros esperando y "
                        + gatoEsp + " gatos esperando!!!");

                if (this.gatoEsp > 0) {
                    gatoCom = 0;
                    System.out.println("--------------------------CAMBIO DE TURNO, LE TOCA A LOS GATOS");

                    if (this.gatoEsp < this.cantMascotas) {
                        this.semGato.release(this.gatoEsp);// Deja entrar solo los Gatos que estan esperando
                        ocupacion = this.gatoEsp;
                    } else {
                        this.semGato.release(this.cantMascotas);// Deja entrar a N Gatos
                        ocupacion = this.cantMascotas;
                    }
                } else {
                    System.out.println("Hay perros esperando o no hay nadie esperando");
                    if (this.perroEsp > 0) {
                        this.perroCom = 0;
                        System.out.println(
                                "--------------------------NO HUBO CAMBIO DE TURNO, SIGUEN COMIENDO LOS PERROS");
                        if (this.perroEsp < this.cantMascotas) {
                            this.semPerro.release(this.perroEsp);// Deja entrar solo los Perros que estan esperando
                            ocupacion = this.perroEsp;
                        } else {
                            this.semPerro.release(this.cantMascotas);// Deja entrar N Perros
                            ocupacion = this.cantMascotas;
                        }
                    } else {
                        // No hay nadie esperando, por lo tanto hay que reiniciar todo
                        ban = true;
                        perroCom = 0;
                        gatoCom = 0;
                        System.out.println("SE REINICIARA EL COMEDOR, SALIO POR PERRO ");

                    } // Fin IfElse
                } // Fin IfElse
            } else {
                if (this.perroEsp == 0) {

                }
            } // Fin IfElse de Ocupacion=0

        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// Fin metodo SalePerro
     // -------------------------------------------------------------------------------------------------------------------------
     // -------------------------------------------------------------------------------------------------------------------------

    public void entraGato() {
        try {

            if (ban) {
                mutex.acquire();
                ban = false;
                mutex.release();
                System.out.println("El primero que entro fue un GATO");
                this.semGato.release(this.cantMascotas);// Habilitar la entrada de N gatos
                System.out.println("Se permiten " + cantMascotas + " GATOS comer!");
            } // Fin If
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin metodo entraPerro

    public void SalaEsperaGato() {
        // El metodo deja entrar a la sala de espera a los gatos y lleva la cuenta
        // de cuantos hay esperando.

        try {
            mutex.acquire();
            this.gatoEsp++;
            mutex.release();
            this.semGato.acquire();// Lo toma para habilitar la entrada de gatos
            System.out.println("Hay: " + gatoEsp + " Gatos esperando");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin metodo SalaEsperaPerro

    public void ComeGato() {
        // El metodo deja entrar a comer y descuenta un gato de los que esperan.
        try {
            this.semPlatos.acquire();
            mutex.acquire();
            this.gatoCom++;
            System.out.println("El GATO " + Thread.currentThread().getName()
                    + " esta COMIENDO");
            this.gatoEsp--;
            mutex.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        } // Fin TryCatch

    }// Fin metodo ComePerro

    public void SaleGato() {
        // El metodo permite que salga el perro, lleva la cuenta de cuantos comieron
        // y decide a quien le da el permiso para ingresar a comer.
        try {
            mutex.acquire();
            System.out.println("El GATO " + Thread.currentThread().getName()
                    + " DEJO DE COMER Y SALE");
            this.semPlatos.release();
            ocupacion--;
            mutex.release();
            if ((this.ocupacion == (this.cantMascotas - this.gatoCom)) && (this.gatoEsp == 0) && primerVuelta) {
                semGato.acquire(ocupacion);
                primerVuelta = false;
                if (this.perroEsp > 0) {
                    mutex.acquire();
                    perroCom = 0;
                    mutex.release();

                    System.out.println("--------------------------CAMBIO DE TURNO, LE TOCA A LOS PERROS");
                    if (this.perroEsp < this.cantMascotas) {
                        this.semPerro.release(this.cantMascotas);// Deja entrar solo los Perros que estan esperando
                        ocupacion = this.perroEsp;
                    } else {
                        this.semPerro.release(this.cantMascotas);// Deja entrar N Perros
                        ocupacion = this.cantMascotas;
                    }
                } else {
                    mutex.acquire();
                    ocupacion = cantMascotas;
                    ban = true;
                    perroCom = 0;
                    gatoCom = 0;
                    System.out.println("SE REINICIARA EL COMEDOR, SALIO POR GATO en la OPCION 2 ");
                    mutex.release();
                } // Fin If de gatos esperando
                System.out.println("ENTRO UNA SOLA VEZ, modificado");
            }

            if (ocupacion == 0) {
                primerVuelta = false;
                System.out.println("Hay: " + perroEsp + " perros esperando y "
                        + gatoEsp + " gatos esperando!!");

                if (this.perroEsp > 0) {
                    perroCom = 0;
                    System.out.println("--------------------------CAMBIO DE TURNO, LE TOCA A LOS PERROS");

                    if (this.perroEsp < this.cantMascotas) {
                        this.semPerro.release(this.cantMascotas);// Deja entrar solo los Perros que estan esperando
                        ocupacion = this.perroEsp;
                    } else {
                        this.semPerro.release(this.cantMascotas);// Deja entrar N Perros
                        ocupacion = this.cantMascotas;
                    }
                } else {
                    // System.out.println("Hay gatos esperando o no hay nadie esperando");
                    if (this.gatoEsp > 0) {
                        gatoCom = 0;
                        System.out.println(
                                "--------------------------NO HUBO CAMBIO DE TURNO, SIGUEN COMIENDO LOS GATOS");

                        if (this.gatoEsp < this.cantMascotas) {
                            this.semGato.release(this.gatoEsp);// Deja entrar solo los Gatos que estan esperando
                            ocupacion = this.gatoEsp;
                        } else {
                            this.semGato.release(this.cantMascotas);// Deja entrar a N Gatos
                            ocupacion = this.cantMascotas;
                        }

                    } else {
                        // No hay nadie esperando, por lo tanto hay que reiniciar todo
                        ban = true;
                        perroCom = 0;
                        gatoCom = 0;
                        System.out.println("SE REINICIARA EL COMEDOR, SALIO POR GATO ");
                    } // Fin IfElse
                } // Fin IfElse
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// Fin metodo SaleGato

}// Fin clase
