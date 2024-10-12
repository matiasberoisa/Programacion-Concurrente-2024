package Test;

import Clases.*;

public class TestControlador {
    public static void main(String[] args) {
        ControladorProduccion elControladorProduccion = new ControladorProduccion();
        Thread hiloControl = new Thread(new Control(elControladorProduccion));
        hiloControl.start();
        for (int j = 1; j <= 10; j++) {
            Thread hiloElectrico = new Thread(new Electrico(elControladorProduccion, j));
            Thread hiloMecanico = new Thread(new Mecanico(elControladorProduccion, j));
            hiloElectrico.start();
            hiloMecanico.start();
        }
    }
}
