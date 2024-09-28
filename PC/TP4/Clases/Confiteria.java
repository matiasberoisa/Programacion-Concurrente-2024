package Clases;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private String[] opciones;
    private Empleado unEmpleado;
    private boolean mesaDisponible;
    private Semaphore semaforoMesa = new Semaphore(0);
    private String orden;

    public Confiteria(String[] opc) {
        opciones = opc;
        unEmpleado = null;
    }

    public String obtenerOpcion(int numero) {
        return this.opciones[numero];
    }

    public int obtenerLongitud() {
        return this.opciones.length;
    }

    public void ocuparMesa(Empleado nuEmpleado) {
        this.unEmpleado = nuEmpleado;
        mesaDisponible = false;
        semaforoMesa.release();

    }

    public void desocuparMesa() {
        mesaDisponible = true;
        try {
            semaforoMesa.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean mesaDisponible() {
        return this.mesaDisponible;
    }

    public void comenzarPedido(String opcion) {
        orden = opcion;
    }

    public void llevarPedido() {
        unEmpleado.comer();
        semaforoMesa.release();
    }

    public void tomarPedido() {
        try {
            semaforoMesa.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String obtenerOrden() {
        return this.orden;
    }
}
