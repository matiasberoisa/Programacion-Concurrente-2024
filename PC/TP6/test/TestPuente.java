package TP6.test;

import TP6.clases.*;

public class TestPuente {
    public static void main(String[] args) {
        Carril puente = new Carril();
        for (int i = 1; i <= 6; i++) {
            Thread hiloAutoNorte = new Thread(new Coche(i, "Norte", puente));
            Thread hiloAutoSur = new Thread(new Coche(i + 10, "Sur", puente));
            hiloAutoNorte.start();
            hiloAutoSur.start();
        }
    }
}
