/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DdeA;

/**
 *
 * @author Mati
 */
public class ej3 {

    public static void main(String[] args) {
        int[] arreglo = {11, 3, 2, 1, 7, 6, 3};
        ordenarSeleccion(arreglo);
        ordenarSeleccionMayor(arreglo);
    }

    public static void ordenarSeleccion(int[] arreglo) {
        int i, posMenor;
        for (i = 0; i < arreglo.length; i++) {
            posMenor = buscarMenor(i, arreglo);
            intercambiar(i, posMenor, arreglo);
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
    }

    public static int buscarMenor(int desde, int[] arreglo) {
        int i = desde, menor, posMenor;
        menor = arreglo[i];
        posMenor = i;
        for (i = desde; i < arreglo.length; i++) {
            if (arreglo[i] < menor) {
                menor = arreglo[i];
                posMenor = i;
            }
        }
        return posMenor;
    }
    
    public static void intercambiar(int pos1, int pos2, int[] arreglo) {
        int aux;
        aux = arreglo[pos1];
        arreglo[pos1] = arreglo[pos2];
        arreglo[pos2] = aux;
    }

    public static void ordenarSeleccionMayor(int[] arreglo) {
        int i, posMayor;
        for (i = 0; i < arreglo.length; i++) {
            posMayor = buscarMayor(i, arreglo);
            intercambiar(i, posMayor, arreglo);
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
    }

    public static int buscarMayor(int desde, int[] arreglo) {
        int i = desde, mayor, posMayor;
        mayor = arreglo[i];
        posMayor = i;
        for (i = desde; i < arreglo.length; i++) {
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
                posMayor = i;
            }
        }
        return posMayor;
    }

    
}
