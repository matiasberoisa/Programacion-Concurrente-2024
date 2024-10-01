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
    private String orden;

    public Confiteria(String[] opciones1, String[] opciones2) {
        opcionesComida = opciones1;
        opcionesBebida = opciones2;
        semaforoMesa = new Semaphore(0);
        semaforoAtender = new Semaphore(0);
        semaforoEmpleado = new Semaphore(2);
        semaforoCocinar = new Semaphore(0);
    }

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

    public void ocuparMesa(Empleado nuEmpleado) {
        try {
            semaforoEmpleado.acquire();
            mesaDisponible = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void desocuparMesa() {
        mesaDisponible = true;
        semaforoAtender.release();
    }

    public Boolean mesaDisponible() {
        return this.mesaDisponible;
    }

    public void comenzarPedido(String opcion) {
        orden = opcion;
        semaforoAtender.release();
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

    public String obtenerOrden() {
        return this.orden;
    }

    public void esperar() {
        try {
            semaforoMesa.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void vigilar() {
        try {
            semaforoAtender.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void limpiarMesa() {
        semaforoEmpleado.release();
    }
}
