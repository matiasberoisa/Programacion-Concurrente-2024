package Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import Clases.Persona;
import Clases.Taxi;

public class TestTaxi {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner dato = new Scanner(System.in);
        Taxi[] taxis = null;
        ArrayList<Thread> hilosTaxis = new ArrayList<>();
        int cantidad;
        System.out.println("ingrese cantidad de taxis");
        cantidad = dato.nextInt();
        taxis = new Taxi[cantidad];
        Semaphore semaforoTaxi = new Semaphore(cantidad);
        Semaphore semaforoPasajero = new Semaphore(1);
        for (int i = 0; i < taxis.length; i++) {
            taxis[i] = new Taxi(semaforoTaxi);
            hilosTaxis.add(new Thread(taxis[i]));
        }
        hilosTaxis.forEach(t -> t.start());
        while (true) {
            Thread hiloPersona = new Thread(new Persona(semaforoPasajero, taxis));
            hiloPersona.start();
        }
    }
}
