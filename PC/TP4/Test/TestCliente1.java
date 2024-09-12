package Test;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import Clases.*;

public class TestCliente1 {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
        Impresora[] impresorasA = null;
        Impresora[] impresorasB = null;
        int numA, numB;
        Scanner dato = new Scanner(System.in);
        Semaphore semaforoFila = new Semaphore(1);
        Semaphore semaforoImpresoraA = null;
        Semaphore semaforoImpresoraB = null;
        System.out.println("ingrese cantidad de impresoras de tipo A");
        numA = dato.nextInt();
        System.out.println("ingrese cantidad de impresoras de tipo B");
        numB = dato.nextInt();
        impresorasA = new Impresora[numA];
        impresorasB = new Impresora[numB];
        semaforoImpresoraA = new Semaphore(numA);
        for (int i = 0; i < numA; i++) {
            impresorasA[i] = new Impresora(i + 1);
        }
        for (int i = 0; i < numB; i++) {
            impresorasB[i] = new Impresora(i + 1);
        }
        GestorImpresora gestor = new GestorImpresora(impresorasA, impresorasB);
        while (true) {
            Thread hiloThread = new Thread(new Cliente(semaforoFila, semaforoImpresoraA, gestor));
            hiloThread.start();
        }
    }
}
