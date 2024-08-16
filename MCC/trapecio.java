package MCC;
import java.util.Scanner;

public class trapecio {
    public static void main(String[] args) {
        try (Scanner dato = new Scanner(System.in)) {
            int valor;
            double[][] valores;
            System.out.println("ingrese cantidad de valores a cargar en la matriz");
            valor = dato.nextInt();
            valores = new double[2][valor];
            for (int i = 0; i < valores.length; i++) {
                System.out.println("fila " + (i + 1));
                for (int j = 0; j < valores[i].length; j++) {
                    System.out.println("ingrese valor de la tabla " + (j + 1));
                    valores[i][j] = dato.nextDouble();
                }
            }

            for (int i = 0; i < valores.length; i++) {
                for (int j = 0; j < valores[i].length; j++) {
                    System.out.print(valores[i][j] + " | ");
                }
                System.out.println();
            }
            // System.out.println(metodoTrapecio(valores, valor));
        }
    }

    public static double metodoTrapecio(double[][] valores, int valor) {
        float h = ((float) valores[0][valores.length - 1] - (float) valores[0][0]) / valor;
        double integral = (h / 2) * (valores[1][0] + valores[1][valores.length - 1] + 2 * (sumatoria(valores[1])));
        return integral;
    }

    public static double sumatoria(double[] tabla) {
        double sumatoria = 0;
        for (int i = 0; i < tabla.length - 1; i++) {
            sumatoria += tabla[i + 1];
        }
        return sumatoria;
    }

    public static double metodoSimpson(double[][] valores, int valor) {
        float h = ((float) valores[0][valores.length - 1] - (float) valores[0][0]) / valor;
        double integral = (h / 3) * (valores[1][0] + valores[1][valores.length - 1]
                + 4 * (sumatoriaSimpson(valores[1], false) + 2 * (sumatoriaSimpson(valores[1], true))));
        return integral;
    }

    public static double sumatoriaSimpson(double[] tabla, boolean esPar) {
        double sumatoria = 0;
        if (esPar) {
            for (int i = 0; i < tabla.length - 1; i++) {
                if ((i+1) % 2 == 0) {
                    sumatoria += tabla[i + 1];
                }
            }
        } else {
            for (int i = 0; i < tabla.length - 1; i++) {
                if ((i+1) % 2 != 0) {
                    sumatoria += tabla[i + 1];
                }
            }
        }
        return sumatoria;
    }
}
