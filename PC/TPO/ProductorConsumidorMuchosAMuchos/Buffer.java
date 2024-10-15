package ProductorConsumidorMuchosAMuchos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private Elemento[ ] elementos;
	private int cantidadElementosListos;
	private int topeBuffer;
	private static int totalElementosProducidos = 0;
	private ReentrantLock lock = new ReentrantLock(true); //declara y crea un cerrojo
	// variables de condicion asociadas a “cerrojo” para control de buffer lleno y vacio
	private Condition productoresEspera = lock.newCondition();
	private Condition consumidoresEspera = lock.newCondition();
	private boolean puedeConsumir, puedeProducir;
	
	public Buffer (int maxElementos) {
		this.elementos = new Elemento [maxElementos];
		this.topeBuffer=maxElementos;
		this.cantidadElementosListos =0;
		this.puedeProducir = true;
		this.puedeConsumir = false;
	}
	public synchronized void empezarProducir() throws InterruptedException {
		lock.lock();
		try {
			while(!puedeProducir) {
				productoresEspera.await();
				lock.unlock();
			}
			if(cantidadElementosListos<topeBuffer) {
				
				System.out.println(Thread.currentThread().getName()+" ESTÁ PRODUCIENDO...");
				totalElementosProducidos++;
				elementos[cantidadElementosListos] = new Elemento("AA"+totalElementosProducidos);
				cantidadElementosListos++;
				Thread.sleep(3000);	
				terminarProducir();
			}
			puedeConsumir = true;
			consumidoresEspera.signal();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public synchronized void terminarProducir() throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+" FINALIZÓ LA PRODUCCIÓN.");
	}
	public synchronized void empezarConsumir() throws InterruptedException{
		lock.lock();
		try {
			while(!puedeConsumir) {
				consumidoresEspera.await();
				lock.unlock();
			}
			
			if(cantidadElementosListos>0) {
				System.out.println(Thread.currentThread().getName()+ " ESTÁ CONSUMIENDO ELEMENTO: "+elementos[cantidadElementosListos-1].getId());
				elementos[cantidadElementosListos-1]= null;
				cantidadElementosListos--;
				Thread.sleep(3000);
				terminarConsumir();
			}
			puedeProducir = true;
			productoresEspera.signal();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public synchronized void terminarConsumir() {
		System.out.println(Thread.currentThread().getName()+" TERMINO DE CONSUMIR 1 ELEMENTO.");
	}
	 
	public int cantElemDisponibles() {
		return this.cantidadElementosListos;
	}
	public int topeBuffer() {
		return this.topeBuffer;
	}
}
