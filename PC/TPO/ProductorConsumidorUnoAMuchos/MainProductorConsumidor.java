package ProductorConsumidorUnoAMuchos;

import java.util.Scanner;

/*PROBLEMA CLÁSICO: PRODUCTOR CONSUMIDOR.
 * CASO: 1 PRODUCTOR Y MUCHOS CONSUMIDORES CON BUFFER LIMITADO.
 * IMPLEMENTADO CON SEMAFORO GENERICOS.*/
public class MainProductorConsumidor {
    public static void main(String[] args) throws InterruptedException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int cant;
        System.out.println("Ingrese la cantidad de consumidores");
        cant = sc.nextInt();
        Buffer rc = new Buffer(cant);
        Thread hiloProductor = new Thread(new Productor(rc));
        hiloProductor.start();
        for (int i = 0; i < cant; i++) {
            Thread hiloConsumidor = new Thread(new Consumidor(rc, i + 1));
            hiloConsumidor.start();
            Thread.sleep(2000);
        }
    }
}
