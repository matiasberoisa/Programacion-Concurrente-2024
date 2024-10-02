package PC.TP5.clases;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private String[] opcionesComida;
    private String[] opcionesBebida;
    private boolean mesaDisponible;
    private Semaphore semaforoMesa;
    private Semaphore semaforoAtender;
    private Semaphore semaforoEmpleado;
    private Semaphore semaforoCocinar;
    private String ordenComida;
    private String ordenBebida;

    public Confiteria(String[] opciones1, String[] opciones2) {
        opcionesComida = opciones1;
        opcionesBebida = opciones2;
        semaforoMesa = new Semaphore(0);
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

    public String obtenerOrdenComida() {
        return this.ordenComida;
    }

    public String obtenerOrdenBebida() {
        return this.ordenBebida;
    }

    public Boolean mesaDisponible() {
        return this.mesaDisponible;
    }

    // metodos referidos a los semaforos

    public void ocuparMesa(Empleado nuEmpleado) {
        try {
            semaforoEmpleado.acquire();
            mesaDisponible = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void desocuparMesa(int opcionPedidos) {
        mesaDisponible = true;
        switch (opcionPedidos) {
            case 1:
                semaforoAtender.release();
                break;
            case 2:
                semaforoCocinar.release();
                break;
            default:
                semaforoAtender.release();
                semaforoCocinar.release();
                break;
        }
    }

    public void llevarPedido() {
        semaforoMesa.release();
    }

    public void atender() {
        try {
            semaforoAtender.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void esperar() {
        try {
            semaforoMesa.acquire();
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

    public void realizarPedidoComida(String opcion) {
        ordenComida = opcion;
        semaforoCocinar.release();
    }

    public void realizarPedidoBebida(String opcion) {
        ordenBebida = opcion;
        semaforoAtender.release();
    }
}
