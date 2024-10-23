package TP5.Test;

import TP5.clases.ej7.*;

public class TestTobogan {
    public static void main(String[] args) {
        Escalera laEscalera = new Escalera();
        Thread hiloEncargado = new Thread(new Encargado(laEscalera));
        int i = 1;
        hiloEncargado.start();
        while (i <= 20) {
            Thread hiloPersona = new Thread(new Persona(i, laEscalera));
            hiloPersona.start();
            i++;
        }
    }
}
