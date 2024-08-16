/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DdeA;
import java.util.Scanner;

/*
 * @author el pibe
 */
public class ejercicio2 {

    /* @param args the command line arguments
     */
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner dato = new Scanner(System.in);
        int longitud;
        //programa
        System.out.println("ingrese la longitud de la matriz");
        longitud = dato.nextInt();
        char[][] matriz = new char[longitud][longitud];
        imprimirMatriz(longitud, matriz);
        imprimirDiagonal(longitud, matriz);
    }
    public static void imprimirMatriz(int longitud, char[][] matriz) {
        Scanner dato = new Scanner(System.in);
        int i,j;
        for (i=0; i<longitud;i++) {
            for(j=0; j<longitud;j++) {
                System.out.println("ingrese el caracter " + (j+1));
                matriz[i][j] = dato.next().charAt(0);
            }
        }
    }
    public static void imprimirDiagonal(int longitud, char[][] matriz) {
        int i,j;
        for (i=0; i< longitud;i++) {
            System.out.print("| ");
            for(j=0; j<longitud;j++) {
                if (i == j) {
                    System.out.print(matriz[i][j] + " ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println("|");
        }
        System.out.println("");
    }
}
