package Test;

import Clases.*;

public class TestControlador {
    public static void main(String[] args) {
        ControladorProduccion elControladorProduccion = new ControladorProduccion();
        Thread hiloControl = new Thread(new Control(elControladorProduccion));
        hiloControl.start();
        int i = 1;
        while (i <= 10) {
            Thread hiloElectrico = new Thread(new Electrico(elControladorProduccion, i));
            Thread hiloMecanico = new Thread(new Mecanico(elControladorProduccion, i));
            hiloElectrico.start();
            hiloMecanico.start();
            i++;
        }
    }
}
