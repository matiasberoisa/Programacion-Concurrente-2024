
package DdeA;

import java.util.Scanner;

public class ej2 {

    public static void main(String[] args) {
        try (Scanner dato = new Scanner(System.in)) {
            int[] a = {2, 3, 4, 6, 8, 10, 12, 14, 16, 18, 20};
            int[] arreglo = {20, 18, 16, 14, 12, 10, 8, 6, 4, 3, 2};
            int n;
            System.out.println("ingrese n");
            n = dato.nextInt();
            System.out.println(busquedaBinaria(a, n));
            System.out.println(busquedaBinariaDecreciente(arreglo, n));
        }

    }

    public static int busquedaBinaria(int[] a, int n) {
        int inicio, fin, medio, resultado;
        inicio = 0;
        fin = a.length - 1;
        resultado = -1;
        while (inicio <= fin) {
            medio = (inicio + fin) / 2;
            if (a[medio] == n) {
                resultado = medio;
                fin = inicio - 1;
            } else if (a[medio] < n) {
                inicio = medio + 1;      
            } else {
                fin = medio - 1;
            }
        }
        return resultado;
    }
    
    public static int busquedaBinariaDecreciente(int[] a, int n) {
        int inicio, fin, medio, resultado;
        inicio = a.length - 1;
        fin = 0;
        resultado = -1;
        while (inicio >= fin) {
            medio = (inicio + fin) / 2;
            if (a[medio] == n) {
                resultado = medio;
                fin = inicio + 1;
            } else if (a[medio] < n) {
                inicio = medio - 1;
            } else {
                fin = medio + 1;
            }
        }
        return resultado;
    }
}
