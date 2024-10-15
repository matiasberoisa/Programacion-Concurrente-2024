package ProductorConsumidorUnoAUno;

public class Consumidor implements Runnable {
	private String id;
	private Buffer almacen;
	private String estado;

	public Consumidor(String i, Buffer unAlmacen) {
		this.id = i;
		this.almacen = unAlmacen;
	}

	@Override
	public void run() {

		int i = 0;
		while (i < 5) {
			if (this.almacen.cantElemDisponibles() > 0) {
				try {
					this.almacen.empezarConsumir();
					this.almacen.terminarConsumir();
					this.almacen.empezarConsumir();
					this.almacen.terminarConsumir();
					i++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getEstado() {
		return this.estado;
	}

	public String getId() {
		return this.id;
	}
}
