package TP5.clases;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private String[] opcionesComida;
    private String[] opcionesBebida;
    private Semaphore semaforoMesa1;
    private Semaphore semaforoMesa2;
    private Semaphore semaforoAtender;
    private Semaphore semaforoEmpleado;
    private Semaphore semaforoCocinar;
    private Semaphore semaforoTrabajar;
    private Mesa mesa1;
    private Mesa mesa2;
    private boolean mesa1disponible;
    private boolean mesa2disponible;

    public Confiteria(String[] opciones1, String[] opciones2) {
        opcionesComida = opciones1;
        opcionesBebida = opciones2;
        mesa1 = null;
        mesa2 = null;
        mesa1disponible = true;
        mesa2disponible = true;
        semaforoTrabajar = new Semaphore(0);
        semaforoMesa1 = new Semaphore(0);
        semaforoMesa2 = new Semaphore(0);
        semaforoAtender = new Semaphore(0);
        semaforoCocinar = new Semaphore(0);
        semaforoEmpleado = new Semaphore(2);
    }

    // metodos referidos a la orden de elementos

    public String obtenerOpcionComida(int numero) {
        return this.opcionesComida[numero];
    }

    public int obtenerLongitudComida() {
        return this.opcionesComida.length;
    }

    public String obtenerOpcionBebida(int numero) {
        return this.opcionesBebida[numero];
    }

    public int obtenerLongitudBebida() {
        return this.opcionesBebida.length;
    }

    public String obtenerOrdenComida(int numMesa) {
        String orden = "";
        if (numMesa == 1) {
            orden = mesa1.getOrdenComida();
        } else {
            orden = mesa2.getOrdenComida();
        }
        return orden;
    }

    public String obtenerOrdenBebida(int numMesa) {
        String orden = "";
        if (numMesa == 1) {
            orden = mesa1.getOrdenBebida();
        } else {
            orden = mesa2.getOrdenBebida();
        }
        return orden;
    }

    // metodos referidos a los semaforos para el empleado

    public int ocuparMesa(Empleado nuEmpleado) {
        int numMesa = 0;
        try {
            semaforoEmpleado.acquire();
            if (mesa1disponible == true) {
                mesa1disponible = false;
                numMesa = 1;
                System.out.println("el empleado " + nuEmpleado.getNombre() + " ocupa la mesa 1");
                semaforoMesa1.release();
            }
            if (mesa2disponible == true && numMesa == 0) {
                mesa2disponible = false;
                numMesa = 2;
                System.out.println("el empleado " + nuEmpleado.getNombre() + " ocupa la mesa 2");
                semaforoMesa2.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numMesa;
    }

    public void desocuparMesa(int opcionPedidos, int num) {
        switch (opcionPedidos) {
            case 1:
                semaforoAtender.release();
                break;
            case 2:
                semaforoCocinar.release();
                break;
        }
        if (num == 1) {
            mesa1disponible = true;
        } else {
            mesa2disponible = true;
        }
    }

    public void realizarPedidoBebida(String opcion, int num) {
        if (num == 1) {
            mesa1 = new Mesa(num, null, opcion);
        } else {
            mesa2 = new Mesa(num, null, opcion);
        }
        llamarMozo();
    }

    public void realizarPedidoComida(String opcion, int num) {
        if (num == 1) {
            mesa1 = new Mesa(num, opcion, null);
        } else {
            mesa2 = new Mesa(num, opcion, null);
        }
        llamarCocinero();
    }

    public void realizarPedido(String opcionComida, String opcionBebida, int num) {
        if (num == 1) {
            mesa1 = new Mesa(num, opcionComida, opcionBebida);
        } else {
            mesa2 = new Mesa(num, opcionComida, opcionBebida);
        }
    }

    public void esperarMesa1() {
        try {
            semaforoMesa1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void esperarMesa2() {
        try {
            semaforoMesa2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void llamarMozo() {
        semaforoTrabajar.release();
        semaforoAtender.release();
    }

    public void llamarCocinero() {
        semaforoTrabajar.release();
        semaforoCocinar.release();
    }

    // metodos referidos a los semaforos para el mozo y cocinero

    public void trabajar() {
        try {
            semaforoTrabajar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void llevarPedidoMesa1() {
        semaforoMesa1.release();
    }

    public void llevarPedidoMesa2() {
        semaforoMesa2.release();
    }

    public void atender() {
        try {
            semaforoAtender.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cocinar() {
        try {
            semaforoCocinar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void vigilarMozo() {
        try {
            semaforoAtender.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void vigilarCocinero() {
        try {
            semaforoCocinar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void habilitarMesa() {
        semaforoEmpleado.release();
    }

    public boolean mesa1ocupada() {
        return mesa1disponible;
    }

    public boolean mesa2ocupada() {
        return mesa2disponible;
    }
}
