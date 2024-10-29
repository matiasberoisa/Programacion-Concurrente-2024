package TP8.tests;

import java.util.Random;

import TP8.clases.ej4.*;

public class TestHemoterapia {
    public static void main(String[] args) {
        Centro hemoterapia = new Centro(10, 4, 9);
        boolean[] deseaSentarse = new boolean[2];
        deseaSentarse[0] = true;
        deseaSentarse[1] = false;
        Random random = new Random();
        for (int i = 1; i <= 15; i++) {
            Thread hiloDonador = new Thread(new Donador(i, hemoterapia, deseaSentarse[random.nextInt(0, 2)]));
            hiloDonador.start();
        }
    }
}
