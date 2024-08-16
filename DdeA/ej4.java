/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DdeA;

/**
 *
 * @author Mati
 */
public class ej4 {

    public static void main(String[] args) {
        int[] arreglo = {11, 3, 2, 1, 7, 6, 3};
        ordenarBurbuja(arreglo);
        ordenarBurbujaMayor(arreglo);
    }

    public static void ordenarBurbuja(int[] arreglo) {
        int i, j;
        for (i = 0; i < arreglo.length; i++) {
            for (j = 0; j < (arreglo.length - i - 1); j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    intercambio(j, j + 1, arreglo);
                }
            }
            System.out.print(arreglo[j] + " ");
        }
        System.out.println("");
    }

    public static void ordenarBurbujaMayor(int[] arreglo) {
        int i, j;
        for (i = 0; i < arreglo.length; i++) {
            for (j = 0; j < (arreglo.length - i - 1); j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    intercambio(j, j + 1, arreglo);
                }
            }
            System.out.print(arreglo[j] + " ");
        }
        System.out.println("");
    }
    public static void intercambio(int j, int n, int[] arreglo) {
        int aux;
        aux = arreglo[j];
        arreglo[j] = arreglo[n];
        arreglo[n] = aux;
    }
}
