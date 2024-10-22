package TP7.test;

import TP7.clases.ej3.*;

public class TestCocineros {
    public static void main(String[] args) {
        Cocina laCocina = new Cocina();
        Thread cocinero1 = new Thread(new Cocineros("Carne", laCocina));
        Thread cocinero2 = new Thread(new Cocineros("Vegetales", laCocina));
        Thread cocinero3 = new Thread(new Cocineros("Pasta", laCocina));
        cocinero1.start();
        cocinero2.start();
        cocinero3.start();
    }
}
