package Clases;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private String[] opciones;
    private boolean mesaDisponible;
    private Semaphore semaforoMesa;
    private Semaphore semaforoAtender;
    private Semaphore semaforoEmpleado;
    private String orden;

    public Confiteria(String[] opc) {
        opciones = opc;
        semaforoMesa = new Semaphore(0);
        semaforoAtender = new Semaphore(0);
        semaforoEmpleado = new Semaphore(1);
    }

    public String obtenerOpcion(int numero) {
        return this.opciones[numero];
    }

    public int obtenerLongitud() {
        return this.opciones.length;
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
