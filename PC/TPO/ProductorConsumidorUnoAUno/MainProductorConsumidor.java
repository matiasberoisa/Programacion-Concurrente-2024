package ProductorConsumidorUnoAUno;
/* PROBLEMA CLÁSICO: PRODUCTOR CONSUMIDOR 
 * CASO: 1 PRODUCTOR Y 1 CONSUMIDOR CON BUFFER LIMITADO.
 * IMPLEMENTADO CON SEMAFORO BINARIO*/
public class MainProductorConsumidor {
	public static void main(String[] args) {
		Buffer almacen = new Buffer(10);
		Productor p1 = new Productor("PRODUCTOR", almacen);
		Consumidor c1 = new Consumidor ("CONSUMIDOR", almacen);
		
		Thread hiloProductor = new Thread (p1, "PRODUCTOR");
		Thread hiloConsumidor = new Thread ( c1, "CONSUMIDOR");
		
		hiloProductor.start();
		hiloConsumidor.start();
		
		try {
			hiloProductor.join();
			hiloConsumidor.join();
		}catch(InterruptedException e) {
			e.getMessage();
		}
	}
}
