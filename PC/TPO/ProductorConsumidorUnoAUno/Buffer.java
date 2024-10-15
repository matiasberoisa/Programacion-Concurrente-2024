package ProductorConsumidorUnoAUno;

import java.util.concurrent.Semaphore;

public class Buffer {
	private Elemento[ ] elementos;
	private int cantidadElementosListos;
	private int topeBuffer;
	private static int totalElementosProducidos = 0;
	Semaphore semProd, semCons;
	
	public Buffer (int maxElementos) {
		this.elementos = new Elemento [maxElementos];
		this.topeBuffer=maxElementos;
		this.cantidadElementosListos =0;
		semProd = new Semaphore(1);
		semCons = new Semaphore(0);
	}
	public void empezarProducir() throws InterruptedException {
		semProd.acquire();
		System.out.println(Thread.currentThread().getName()+" ESTÁ PRODUCIENDO...");
		totalElementosProducidos++;
		elementos[cantidadElementosListos] = new Elemento("AA"+totalElementosProducidos);
		cantidadElementosListos++;
		Thread.sleep(5000);
	}
	
	public void terminarProducir() throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+" FINALIZÓ LA PRODUCCIÓN.");
		semProd.release();
		semCons.release();
	}
	public void empezarConsumir() throws InterruptedException{
		semCons.acquire();
		System.out.println(Thread.currentThread().getName()+ " ESTÁ CONSUMIENDO ELEMENTO: "+elementos[cantidadElementosListos-1].getId());
		elementos[cantidadElementosListos-1]= null;
		cantidadElementosListos--;
		Thread.sleep(6000);
	}
	public void terminarConsumir() {
		System.out.println(Thread.currentThread().getName()+" TERMINO DE CONSUMIR 1 ELEMENTO.");
		semProd.release();
		semCons.release();
	}
	
	public int cantElemDisponibles() {
		return this.cantidadElementosListos;
	}
	public int topeBuffer() {
		return this.topeBuffer;
	}
}
