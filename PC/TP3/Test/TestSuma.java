package TP3.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import TP3.Clases.Suma;

public class TestSuma {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[50000];
        Suma[] sumas;
        boolean terminado = false;
        @SuppressWarnings("resource")
        Scanner dato = new Scanner(System.in);
        ArrayList<Thread> hilosSumas = new ArrayList<Thread>();
        Random numRandom = new Random();
        int cantidadHilos, limite, resultadoTotal = 0, pos = 0;
        System.out.println("ingresa la cantidad de hilos");
        cantidadHilos = dato.nextInt();
        sumas = new Suma[cantidadHilos];
        limite = numeros.length / cantidadHilos;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = numRandom.nextInt(1, 10);
        }
        for (int i = 0; i < cantidadHilos; i++) {
            sumas[i] = new Suma(numeros, i + 1, limite);
            Thread hiloSuma = new Thread(sumas[i]);
            hilosSumas.add(hiloSuma);
        }
        hilosSumas.forEach(a -> a.start());
        while (!terminado) {
            if (pos < cantidadHilos) {
                if (sumas[pos].terminoSumar()) {
                    pos++;
                }
            } else {
                terminado = true;
            }
        }
        for (int i = 0; i < sumas.length; i++) {
            resultadoTotal += sumas[i].getResultadoParcial();
        }
        System.out.println("el resultadoTotal es: " + resultadoTotal);
    }
}
