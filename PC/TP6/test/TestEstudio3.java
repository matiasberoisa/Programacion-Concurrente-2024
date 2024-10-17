package TP6.test;

import java.util.Scanner;
import TP6.clases.ej3.*;

public class TestEstudio3 {
    public static void main(String[] args) {
        try (Scanner dato = new Scanner(System.in)) {
            Mesa[] mesas = null;
            int cant, j = 1;
            System.out.println("ingrese la cantidad de mesas");
            cant = dato.nextInt();
            mesas = new Mesa[cant];
            for (int i = 0; i < mesas.length; i++) {
                mesas[i] = new Mesa(i + 1);
            }
            Estudio elEstudio = new Estudio(mesas);
            while (j <= 10) {
                Thread hiloEstudiante = new Thread(new Estudiante(j, elEstudio));
                hiloEstudiante.start();
                j++;
            }
        }
    }
}
