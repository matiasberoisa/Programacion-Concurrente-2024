package TP6.test;

import java.util.ArrayList;
import java.util.Scanner;

import TP6.clases.ej4.Buffer;
import TP6.clases.ej4.Consumidor;
import TP6.clases.ej4.Productor;

/*PROBLEMA CLÁSICO: PRODUCTOR CONSUMIDOR.
 * CASO: MUCHOS PRODUCTORES Y 1 CONSUMIDOR CON BUFFER LIMITADO.
 * IMPLEMENTADO CON MONITOR.*/
public class TestProductorConsumidor {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Buffer almacen = new Buffer(10);
		System.out.println("Ingrese la cantidad de productores");
		int cant = sc.nextInt();
		ArrayList<Thread> productores = new ArrayList<>();
		ArrayList<Thread> consumidores = new ArrayList<>();
		for (int k = 0; k < cant; k++) {
			productores.add(new Thread(new Productor("PRODUCTOR " + (k + 1), almacen), "PRODUCTOR" + (k + 1)));
			consumidores.add(new Thread(new Consumidor("CONSUMIDOR", almacen)));
		}
	}
}
