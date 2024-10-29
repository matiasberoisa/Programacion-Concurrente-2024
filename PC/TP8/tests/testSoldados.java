package TP8.tests;

import java.util.Random;
import java.util.Scanner;

import TP8.clases.ej1.*;

public class testSoldados {
    public static void main(String[] args) {
        try (Scanner dato = new Scanner(System.in)) {
            Recinto elRecinto = new Recinto();
            int cantidad;
            Random random = new Random();
            String[] bebidas = new String[2];
            String[] postres = new String[2];
            bebidas[0] = "vaso de agua";
            bebidas[1] = "gaseosa";
            postres[0] = "SI";
            postres[1] = "NO";
            System.out.println("ingrese cantidad de soldados");
            cantidad = dato.nextInt();
            for (int i = 1; i <= cantidad; i++) {
                Thread hiloSoldado = new Thread(
                        new Soldado(i, elRecinto, bebidas[random.nextInt(0, 2)], postres[random.nextInt(0, 2)]));
                hiloSoldado.start();
            }
        }
    }
}
