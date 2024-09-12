package Test;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import Clases.*;

public class TestCliente {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Impresora[] impresoras = null;
        Scanner dato = new Scanner(System.in);
        Semaphore semaforoFila = new Semaphore(1);
        Semaphore semaforoImpresora = null;
        System.out.println("ingrese cantidad de impresoras");
        int cantidad = dato.nextInt();
        impresoras = new Impresora[cantidad];
        semaforoImpresora = new Semaphore(cantidad);
        for (int i = 0; i < cantidad; i++) {
            impresoras[i] = new Impresora(i + 1);
        }
        GestorImpresora gestor = new GestorImpresora(impresoras);
        while (true) {
            Thread hiloThread = new Thread(new Cliente(semaforoFila, semaforoImpresora, gestor));
            hiloThread.start();
        }
    }
}
