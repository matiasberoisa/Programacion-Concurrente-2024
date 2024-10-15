package ProductorConsumidorMuchosAUno;

import java.util.Scanner;

/*PROBLEMA CLÁSICO: PRODUCTOR CONSUMIDOR.
 * CASO: MUCHOS PRODUCTORES Y 1 CONSUMIDOR CON BUFFER LIMITADO.
 * IMPLEMENTADO CON MONITOR.*/
public class MainProductorConsumidor {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Buffer almacen = new Buffer(10);

		Consumidor c1 = new Consumidor("CONSUMIDOR", almacen);

		System.out.println("Ingrese la cantidad de productores");
		int cant = sc.nextInt();
		Thread[] productores = new Thread[cant];
		for (int k = 0; k < cant; k++) {
			productores[k] = new Thread(new Productor("PRODUCTOR " + (k + 1), almacen), "PRODUCTOR" + (k + 1));
			productores[k].start();
		}
		Thread hiloConsumidor = new Thread(c1, "CONSUMIDOR");

		hiloConsumidor.start();
	}
}
