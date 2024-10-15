package ProductorConsumidorMuchosAMuchos;

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

		while (true) {
			if (this.almacen.cantElemDisponibles() > 0) {
				try {
					for (int k = 0; k < 3; k++) {
						this.almacen.empezarConsumir();
					}
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
