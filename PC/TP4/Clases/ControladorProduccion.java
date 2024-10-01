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
        contadorProducto = 1;
    }

    public void cambiaLineas(String tipo) {
        try {
            if (tipo.equals("Mecanico")) {
                semaforoLineaElectrico.release();
                semaforoLineaMecanico.acquire();
            }
            if (tipo.equals("Electrico")) {
                semaforoLineaElectrico.acquire();
                semaforoLineaMecanico.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sale() {
        try {
            System.out.println("sale un producto de la linea");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void controlar() {
        try {
            semaforoControl.acquire();
            contadorProducto++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void realizarCambio() {
        if (contadorProducto % 5 == 0) {
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
}
