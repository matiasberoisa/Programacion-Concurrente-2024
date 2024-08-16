/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DdeA;

import java.util.Scanner;

/**
 *
 * @author Mati
 */
public class ejercicio3a {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (
                Scanner dato = new Scanner(System.in)) {
            int cantidad, i = 0, cantidadPalabras = 0;
            String frase;
            System.out.println("cuantas oraciones desea ingresar?");
            cantidad = dato.nextInt();
            String[] oracion = new String[cantidad];
            for (i = 0; i < oracion.length; i++) {
                System.out.println("Ingrese la oracion " + (i + 1));
                frase = dato.nextLine();
                oracion[i] = frase;
                cantidadPalabras = cantidadPalabras(frase);
            }
            ponerOracionEnMatriz(oracion, cantidad, cantidadPalabras);
        }
    }

    public static int cantidadPalabras(String frase) {
        char posicion;
        int i, j = 0, cantidadPalabras;
        for (i = 0; i < frase.length(); i++) {
            posicion = frase.charAt(i);
            if (posicion == ' ') {
                j++;
            }
        }
        cantidadPalabras = j + 1;
        return cantidadPalabras;
    }

    public static void ponerOracionEnMatriz(String[] oracion, int cantidad, int cantidadPalabras) {
        String[] matriz = new String[cantidad];
        int i;
        for (i = 0; i < cantidad; i++) {
            matriz[i] = oracion[i];
        }
        for (i = 0; i < cantidad; i++) {
            if (cantidad == cantidadPalabras) {
                System.out.print("| ");
                System.out.print(matriz[i] + " ");
                System.out.println("|");
            }
        }
    }
}
