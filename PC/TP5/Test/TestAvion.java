package TP5.Test;

import java.util.Random;

import TP5.clases.ej6.*;

public class TestAvion {
    public static void main(String[] args) {
        Pista laPista = new Pista();
        Thread hiloTorre = new Thread(new Torre(laPista));
        String[] condiciones = new String[2];
        condiciones[0] = "Aterrizar";
        condiciones[1] = "Despegar";
        Random random = new Random();
        int i = 1, valor;
        hiloTorre.start();
        while (i <= 20) {
            valor = random.nextInt(0, 2);
            Thread hiloAvion = new Thread(new Avion(laPista, condiciones[valor]));
            hiloAvion.start();
            i++;
        }
    }
}
