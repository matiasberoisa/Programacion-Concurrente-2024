/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DdeA;

/**
 *
 * @author Mati
 */
public class ej6 {

    public static void main(String[] args) {
        int[] arreglo = {11, 3, 2, 1, 7, 6, 3};
        burbujaMejorada(arreglo);
        /*for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");*/
        burbujaMejoradaMayor(arreglo);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
    }

    public static void burbujaMejorada(int[] arreglo) {
        boolean ordenado = false;
        int i = 0, j;
        while ((i < arreglo.length - 1) && (!ordenado)) {
            ordenado = true;
            for (j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    ordenado = false;
                    intercambio(j, j + 1, arreglo);
                }
            }
            i++;
        }
    }

    public static void burbujaMejoradaMayor(int[] arreglo) {
        boolean ordenado = false;
        int i = 0, j;
        while ((i < arreglo.length - 1) && (!ordenado)) {
            ordenado = true;
            for (j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    ordenado = false;
                    intercambio(j, j + 1, arreglo);
                }
                System.out.print(arreglo[j] + " ");
            }
            System.out.println("");
            i++;
        }
    }

    public static void intercambio(int j, int n, int[] arreglo) {
        int aux;
        aux = arreglo[j];
        arreglo[j] = arreglo[n];
        arreglo[n] = aux;
    }
}
