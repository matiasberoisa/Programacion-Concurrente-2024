package TP7.test;

import TP7.clases.ej2.*;

public class TestProgramador {
    public static void main(String[] args) {
        Computadora laComputadora = new Computadora();
        Libro libroReferencia = new Libro();
        int i = 1;
        while (i <= 3) {
            Thread hiloProgramador = new Thread(new Programador(i, laComputadora, libroReferencia));
            hiloProgramador.start();
            i++;
        }
    }
}
