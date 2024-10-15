package ProductorConsumidorMuchosAUno;



public class Buffer {
	private Elemento[ ] elementos;
	private int cantidadElementosListos;
	private int topeBuffer;
	private static int totalElementosProducidos = 0;
	private boolean puedeConsumir, puedeProducir;

	
	public Buffer (int maxElementos) {
		this.elementos = new Elemento [maxElementos];
		this.topeBuffer=maxElementos;
		this.cantidadElementosListos =0;
		this.puedeProducir = true;
		this.puedeConsumir = false;
	}
	public synchronized void empezarProducir() throws InterruptedException {
		while(!puedeProducir) {
			wait();
		}
		if(puedeProducir) {
			System.out.println(Thread.currentThread().getName()+" ESTÁ PRODUCIENDO...");
			totalElementosProducidos++;
			elementos[cantidadElementosListos] = new Elemento("AA"+totalElementosProducidos);
			cantidadElementosListos++;
			Thread.sleep(5000);
		}
	}
	
	public synchronized void terminarProducir() throws InterruptedException{
		
		this.puedeProducir = false;
		this.puedeConsumir = true;
		System.out.println(Thread.currentThread().getName()+" FINALIZÓ LA PRODUCCIÓN.");
		notifyAll();
	}
	public synchronized void empezarConsumir() throws InterruptedException{
		while(!puedeConsumir) {
			wait();
		}
		if(puedeConsumir){
			System.out.println(Thread.currentThread().getName()+ " ESTÁ CONSUMIENDO ELEMENTO: "+elementos[cantidadElementosListos-1].getId());
			elementos[cantidadElementosListos-1]= null;
			cantidadElementosListos--;
			Thread.sleep(6000);
		}
		
	}
	public synchronized void terminarConsumir() {
		
		this.puedeConsumir = false;
		this.puedeProducir = true;
		System.out.println(Thread.currentThread().getName()+" TERMINO DE CONSUMIR 1 ELEMENTO.");
		notifyAll();
	}
	 
	public int cantElemDisponibles() {
		return this.cantidadElementosListos;
	}
	public int topeBuffer() {
		return this.topeBuffer;
	}
}
