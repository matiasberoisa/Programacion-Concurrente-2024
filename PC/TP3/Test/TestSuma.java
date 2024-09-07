package PC.TP3.Test;

import java.util.ArrayList;
import java.util.Random;

import PC.TP3.Clases.Suma;

public class TestSuma {
    public static void main(String[] args) {
        int[] numeros = new int[50000];
        ArrayList<Thread> hilosSumas = new ArrayList<Thread>();
        Random numRandom = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = numRandom.nextInt(1, 10);
        }
        for (int i = 0; i < 5; i++) {
            Thread hiloSuma = new Thread(new Suma(numeros, i + 1));
            hilosSumas.add(hiloSuma);
        }
        hilosSumas.forEach(a -> a.start());
    }
}
