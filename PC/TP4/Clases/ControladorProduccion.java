package Clases;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    private Semaphore semaforoLineaElectrico;
    private Semaphore semaforoLineaMecanico;

    public ControladorProduccion(Semaphore sE, Semaphore sM) {
        semaforoLineaElectrico = sE;
        semaforoLineaMecanico = sM;
    }

    public void cambiaLineas() {

    }

    public void sale() {

    }
}
