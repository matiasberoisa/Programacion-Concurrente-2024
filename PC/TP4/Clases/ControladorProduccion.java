package Clases;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    private Semaphore semaforoLineaElectrico;
    private Semaphore semaforoLineaMecanico;
    private Semaphore semaforoElemento;
    private Semaphore semaforoControl;
    private int contadorProducto;

    public ControladorProduccion() {
        semaforoLineaElectrico = new Semaphore(1);
        semaforoLineaMecanico = new Semaphore(0);
        semaforoControl = new Semaphore(0);
        semaforoElemento = new Semaphore(1);
        contadorProducto = 0;
    }

    public void cambiaLineas(String tipo) {
        try {
            if (tipo.equals("Mecanico")) {
                semaforoLineaElectrico.acquire();
                semaforoLineaMecanico.release();
            }
            if (tipo.equals("Electrico")) {
                semaforoLineaMecanico.acquire();
                semaforoLineaElectrico.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sale() {
        try {
            System.out.println("sale un producto de la linea");
            Thread.sleep(1000);
            this.liberarLineaEnsamblaje();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void controlar() {
        try {
            semaforoControl.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void realizarCambio() {
        if (contadorProducto % 3 == 0) {
            semaforoControl.release();
        }
    }

    public void ocuparLineaEnsamblaje() {
        try {
            semaforoElemento.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void liberarLineaEnsamblaje() {
        semaforoElemento.release();
    }

    public void contarProducto() {
        contadorProducto++;
    }

    public boolean puedeIngresarElectrico() {
        return semaforoLineaElectrico.tryAcquire();
    }

    public boolean puedeIngresarMecanico() {
        return semaforoLineaMecanico.tryAcquire();
    }
}
