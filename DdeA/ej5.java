/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DdeA;

/**
 *
 * @author Mati
 */
public class ej5 {

    public static void main(String[] args) {
        int[] arreglo = {11, 3, 2, 1, 7, 6, 3};
        int i;
        insercion(arreglo);
        for (i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
        insercionMayor(arreglo);
        for (i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
    }

    public static void insercion(int[] arreglo) {
        int i;
        for (i = 0; i < arreglo.length; i++) {
            reubica(arreglo, i);
        }
    }

    public static void reubica(int[] arreglo, int i) {
        int j, aux;
        aux = arreglo[i];
        j = i;
        while (j > 0 && aux < arreglo[j - 1]) {
            arreglo[j] = arreglo[j - 1];
            j--;
        }
        arreglo[j] = aux;
    }
    
    public static void insercionMayor(int[] arreglo) {
        int i;
        for (i = 0; i < arreglo.length; i++) {
            reubicaMayor(arreglo, i);
        }
    }
    public static void reubicaMayor(int[] arreglo, int i) {
        int j, aux;
        aux = arreglo[i];
        j = i;
        while (j > 0 && aux > arreglo[j - 1]) {
            arreglo[j] = arreglo[j - 1];
            j--;
        }
        arreglo[j] = aux;
    }
}
