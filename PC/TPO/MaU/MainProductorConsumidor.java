package MaU;

import java.util.Scanner;

public class MainProductorConsumidor {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Buffer almacen = new Buffer(10);
            Consumidor c1 = new Consumidor("CONSUMIDOR", almacen);
            System.out.println("Ingrese la cantidad de productores");
            int cant = sc.nextInt();
            Thread[] productores = new Thread[cant];

            for (int k = 0; k < cant; ++k) {
                productores[k] = new Thread(new Productor("PRODUCTOR " + (k + 1), almacen), "PRODUCTOR");
                productores[k].start();
            }

            Thread hiloConsumidor = new Thread(c1, "CONSUMIDOR");
            hiloConsumidor.start();
        }
    }
}
