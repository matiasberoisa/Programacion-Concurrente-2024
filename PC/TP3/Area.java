package PC.TP3;

public class Area {
    private Persona[] espacio;
    private int posicion;

    public Area() {
        espacio = new Persona[50];
        posicion = 0;
    }

    public boolean espaciosLibres() {
        int i = 0;
        boolean espacioVacio = false;
        while (espacio[i] != null) {
            i++;
            espacioVacio = (espacio[i] != null);
        }
        return espacioVacio;
    }

    public int cantEspaciosLibres() {
        int i = 0, cant = 0;
        while (i < espacio.length) {
            if (espacio[i] == null) {
                cant++;
            }
            i++;
        }
        return cant;
    }

    public synchronized void reservar(Persona visitante) {
        try {
            while (posicion < visitante.getCantReservas()) {
                System.out.println("la persona " + visitante.getNombre() + " ocupa el lugar " + posicion);
                posicion++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
