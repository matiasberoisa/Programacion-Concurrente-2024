package TP5.Test;

import TP5.clases.*;

public class TestConfiteria {
    public static void main(String[] args) {
        String[] opcionesComida = new String[5];
        String[] opcionesBebida = new String[5];
        int i = 1;
        Confiteria laConfiteria = null;
        Mozo unMozo = null;
        Cocinero unCocinero = null;
        opcionesComida[0] = "pollo Argentina";
        opcionesComida[1] = "pollo Chile";
        opcionesComida[2] = "pollo Brasil";
        opcionesComida[3] = "pollo Uruguay";
        opcionesComida[4] = "pollo KFC";
        opcionesBebida[0] = "jugo de naranja";
        opcionesBebida[1] = "jugo de limon";
        opcionesBebida[2] = "speed";
        opcionesBebida[3] = "monster";
        opcionesBebida[4] = "cafe";
        laConfiteria = new Confiteria(opcionesComida, opcionesBebida);
        unMozo = new Mozo(laConfiteria);
        unCocinero = new Cocinero(laConfiteria);
        System.out.println("se abre la confiteria");
        Thread hiloMozo = new Thread(unMozo);
        hiloMozo.start();
        Thread hiloCocinero = new Thread(unCocinero);
        hiloCocinero.start();
        while (true) {
            Thread hiloEmpleado = new Thread(new Empleado(i, laConfiteria));
            hiloEmpleado.start();
            i++;
        }
    }
}
