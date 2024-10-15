package ProductorConsumidorUnoAUno;

public class Productor implements Runnable {
	private String id;
	private Buffer almacen;
	private String estado;

	public Productor(String i, Buffer unAlmacen) {
		this.id = i;
		this.almacen = unAlmacen;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 5) {
			if (this.almacen.topeBuffer() > this.almacen.cantElemDisponibles()) {
				try {
					this.almacen.empezarProducir();
					this.almacen.terminarProducir();
					this.almacen.empezarProducir();
					this.almacen.terminarProducir();
					i++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(2000);
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
