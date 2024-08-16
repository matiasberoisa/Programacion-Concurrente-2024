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
public class ejercicio9 {
    
    /* @param args the command line arguments
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // algoritmo que permite ingresar una matriz y un arreglo de numeros, el cual es ingresado a una fila de la matriz y es devuelta la matriz resultante
        // declaracion de variables
        Scanner dato = new Scanner(System.in);
        int fila, col, nuevaFila;
        //programa
        System.out.println("ingrese la longitud de la fila");
        fila = dato.nextInt();
        System.out.println("ingrese la longitud de la columna");
        col = dato.nextInt();
        int[][] matriz = new int[fila][col];
        int[] arreglo = new int[col];
        System.out.println("que fila desea cambiar?");
        nuevaFila = dato.nextInt();
        escribirMatriz(fila,col, matriz);
        imprimirArreglo(arreglo);
        imprimirMatriz(fila,col, matriz);
        cambiarFilaMatriz(fila,col,matriz,nuevaFila,arreglo);
    }
    public static void escribirMatriz(int fila, int col, int[][] matriz) {
        Scanner dato = new Scanner(System.in);
        int i,j;
        for (i=0; i<fila;i++) {
            for(j=0; j<col;j++) {
                System.out.println("ingrese el numero " + (j+1));
                matriz[i][j] = dato.nextInt();
            }
        }
    }
    public static void imprimirMatriz(int fila, int col, int[][] matriz) {
        int i,j;
        System.out.println("matriz inicial:");
        for (i=0; i< fila;i++) {
            System.out.print("| ");
            for(j=0; j<col;j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("");
    }

    public static void imprimirArreglo(int[] arreglo) {
        try (Scanner dato = new Scanner(System.in)) {
            int j;
            for (j = 0; j < arreglo.length; j++) {
               System.out.println("ingrese el elemento " + (j+1));
               arreglo[j] = dato.nextInt();
            }
            System.out.println("arreglo ingresado");
            System.out.print("|");
            for (j=0; j< arreglo.length;j++) {
                System.out.print(arreglo[j] + "|");
            }
        }
        System.out.println("");
    }
    public static void cambiarFilaMatriz(int fila, int col, int[][] matriz, int nuevaFila, int[] arreglo) {
        int i,j,n;
        n = nuevaFila - 1;
        System.out.println("matriz resultante:");
        for (i=0; i< fila;i++) {
            System.out.print("| ");
            for(j=0; j<col;j++) {
                if ( i == n) {
                    System.out.print(arreglo[j] + " ");
                }
                else {
                    System.out.print(matriz[i][j] + " ");   
                }
            }
            System.out.println("|");
        }
    }
}


