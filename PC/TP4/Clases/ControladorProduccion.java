package Clases;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    private Semaphore semaforoLinea;
    private String lineaActual;

    public ControladorProduccion() {
        semaforoLinea = new Semaphore(1);
        lineaActual = "Electrico";
    }

    public void cambiarLinea(String tipo) {
        lineaActual = tipo;
    }

    public boolean puedeIngresar(Producto unProducto) {
        boolean ensamblado = false;
        try {
            semaforoLinea.acquire();
            if (unProducto.getTipo().equals(lineaActual)) {
                ensamblado = true;
                System.out.println("el producto " + unProducto.getTipo() + " n° " + unProducto.getNumero()
                        + " entra a la linea de ensamblaje");
                Thread.sleep(1000);
                System.out.println("se comienza a ensamblar el producto " + unProducto.getTipo() + " n° "
                        + unProducto.getNumero());
                Thread.sleep(3000);
                System.out.println(
                        "el producto " + unProducto.getTipo() + " n° " + unProducto.getNumero()
                                + " termina el ensamblaje y sale de la linea");
            }
            semaforoLinea.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ensamblado;
    }
}
