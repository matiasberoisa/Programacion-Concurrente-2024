package DdeA;

import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        try (Scanner dato = new Scanner(System.in)) {
            int[] arreglo = {89, 45, 63, 90, 29, 34, 17};
            int n;
            System.out.println("ingrese n");
            n = dato.nextInt();
            System.out.println(busquedaSecuencial(arreglo, n));
        }
        
    }

    public static int busquedaSecuencial(int[] a, int n) {
        int num = -1, i = 0;
        // el modulo devuelve -1 si no se encuentra el numero
        while (i < a.length) {
            if (a[i] == n) {
                num = (i+1);
            }
            i++;
        }
        return num;
    }
    public static int busquedaSecuencialInversa(int[] a, int n) {
        int num = -1, i = a.length - 1;
        // el modulo devuelve -1 si no se encuentra el numero
        while (i >= 0) {
            if (a[i] == n) {
                num = i;
            }
            i--;
        }
        return num;
    }
}
