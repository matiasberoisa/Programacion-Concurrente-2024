package ProductorConsumidorMuchosAMuchos;

import java.util.Scanner;

/*PROBLEMA CLÁSICO: PRODUCTOR CONSUMIDOR.
 * CASO: MUCHOS PRODUCTORES Y MUCHOS CONSUMIDORES CON BUFFER LIMITADO.
 * IMPLEMENTADO CON LOCKS Y VARIABLES DE CONDICIÓN.*/
public class MainProductorConsumidor {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Buffer almacen = new Buffer(10);

			System.out.println("Ingrese la cantidad de productores");
			int cantP = sc.nextInt();
			System.out.println("Ingrese la cantidad de consumidores");
			int cantC = sc.nextInt();
			Thread[] productores = new Thread[cantP];
			Thread[] consumidores = new Thread[cantC];
			for (int k = 0; k < cantP; k++) {
				productores[k] = new Thread(new Productor("PRODUCTOR " + (k + 1), almacen), "PRODUCTOR " + (k + 1));
				productores[k].start();
			}
			for (int j = 0; j < cantC; j++) {
				consumidores[j] = new Thread(new Consumidor("CONSUMIDOR " + (j + 1), almacen), "CONSUMIDOR " + (j + 1));
				consumidores[j].start();
			}
		}

	}
}
