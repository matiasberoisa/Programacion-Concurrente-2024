/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DdeA;

import java.util.Scanner;

/**
 *
 * @author Mati
 */
public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        int cantidad,i = 0;
        String frase, palabras = null;
        System.out.println("cuantas oraciones desea ingresar?");
        cantidad = dato.nextInt();
        String[] oracion = new String[cantidad];
        for (i = 0; i < oracion.length; i++){
            System.out.println("Ingrese la oracion " + (i+1));
            frase = dato.nextLine();
            palabras = palabras(frase);
        }
        System.out.println(palabras);
    }
    
    public static String palabras(String frase) {
        char posicion;
        String palabra = null;
        int i,j=0,indInicial;
        for (i = 0; i < frase.length(); i++) {
            posicion = frase.charAt(i);
            if (!(posicion == ' ')) {
                j++;
            }
            else {
                indInicial = i - j;
                palabra = frase.substring(indInicial,j);
            }
        }
        return palabra;
    }

    public static void ponerOracionEnMatriz(String[] oracion,int cantidad, int cantidadPalabras) {
        String[] matriz = new String[cantidad];
        int i;
        for(i = 0;i < cantidad;i++) {
            matriz[i] = oracion[i];
        }
        for(i = 0;i < cantidad;i++) {
            System.out.print("| ");
            System.out.print(matriz[i] + " ");
            System.out.println("|");
        }
    }
}
