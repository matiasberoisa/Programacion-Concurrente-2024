package Clases;

public class Confiteria {
    private String[] opciones;
    private Empleado unEmpleado;
    private boolean mesaDisponible;
    private Mozo unMozo;

    public Confiteria(Mozo moz, String[] opc) {
        opciones = opc;
        unEmpleado = null;
        unMozo = moz;
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
    }

    public void desocuparMesa() {
        mesaDisponible = true;
        unMozo.descansar();
    }

    public Boolean mesaDisponible() {
        return this.mesaDisponible;
    }

    public void comenzarPedido(String opcion) {
        unMozo.realizarOrden(opcion);
        llevarPedido();
    }

    public void llevarPedido() {
        unEmpleado.comer();
    }
}
