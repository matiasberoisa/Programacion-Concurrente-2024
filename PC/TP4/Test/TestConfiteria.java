package Test;

import Clases.*;

public class TestConfiteria {
    public static void main(String[] args) {
        String[] opciones = new String[5];
        Confiteria laConfiteria = null;
        Mozo unMozo = null;
        opciones[0] = "pollo Argentina";
        opciones[1] = "pollo Chile";
        opciones[2] = "pollo Brasil";
        opciones[3] = "pollo Uruguay";
        opciones[4] = "pollo KFC";
        laConfiteria = new Confiteria(opciones);
        unMozo = new Mozo(laConfiteria);
        System.out.println("se abre la confiteria");
        Thread hiloMozo = new Thread(unMozo);
        hiloMozo.start();
        while (true) {
            Thread hiloEmpleado = new Thread(new Empleado(laConfiteria));
            hiloEmpleado.start();
        }
    }
}
