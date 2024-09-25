package Clases;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private String[] opciones;
    private Empleado unEmpleado;
    private boolean mesaDisponible;
    private Semaphore semaforoMesa = new Semaphore(0);
    private Semaphore semaforoEspera = new Semaphore(1);
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

    }

    public Boolean mesaDisponible() {
        return this.mesaDisponible;
    }

    public void comenzarPedido(String opcion) {
        orden = opcion;
        llevarPedido();
    }

    public void llevarPedido() {
        unEmpleado.comer();
    }

    public void tomarPedido() {
        semaforoMesa.acquire();
        //
        //
    }
}
