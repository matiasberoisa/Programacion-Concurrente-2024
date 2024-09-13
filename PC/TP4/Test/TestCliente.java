package Test;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import Clases.*;

public class TestCliente {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
        Impresora[] impresorasA = null;
        Impresora[] impresorasB = null;
        String[] tipos = new String[3];
        Random random = new Random();
        Scanner dato = new Scanner(System.in);
        Semaphore semaforoFila = new Semaphore(3);
        Semaphore semaforoImpresoraA = null;
        Semaphore semaforoImpresoraB = null;
        int posTipos, numA, numB;
        tipos[0] = "A";
        tipos[1] = "B";
        tipos[2] = "C";
        System.out.println("ingrese cantidad de impresoras de tipo A");
        numA = dato.nextInt();
        System.out.println("ingrese cantidad de impresoras de tipo B");
        numB = dato.nextInt();
        impresorasA = new Impresora[numA];
        impresorasB = new Impresora[numB];
        semaforoImpresoraA = new Semaphore(numA);
        semaforoImpresoraB = new Semaphore(numB);
        for (int i = 0; i < numA; i++) {
            impresorasA[i] = new Impresora(i + 1, "A");
        }
        for (int i = 0; i < numB; i++) {
            impresorasB[i] = new Impresora(i + 1, "B");
        }
        GestorImpresora gestor = new GestorImpresora(impresorasA, impresorasB);
        while (true) {
            posTipos = random.nextInt(0, 3);
            Thread hiloThread = new Thread(
                    new Cliente(semaforoFila, semaforoImpresoraA, semaforoImpresoraB, gestor,
                            tipos[posTipos]));
            hiloThread.start();
        }
    }
}
