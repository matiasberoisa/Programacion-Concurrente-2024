package TP6.clases.ej4;

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
		while (true) {
			if (this.almacen.topeBuffer() > this.almacen.cantElemDisponibles()) {
				try {
					this.almacen.empezarProducir();
					Thread.sleep(5000);
					this.almacen.terminarProducir();
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
