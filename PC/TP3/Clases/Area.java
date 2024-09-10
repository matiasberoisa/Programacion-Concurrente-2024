package PC.TP3.Clases;

public class Area {
    private Persona[] espacio;
    private int numero;
    private int posicion;

    public Area(int num) {
        espacio = new Persona[100];
        numero = num;
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
        int cant = 0;
        for (int j = 0; j < espacio.length; j++) {
            if (espacio[j] == null) {
                cant++;
            }
        }
        return cant;
    }

    public synchronized void reservar(Persona visitante) {
        int contador = 0;
        boolean finalizado = false;
        try {
            while (posicion < espacio.length && !finalizado) {
                if (contador < visitante.getCantReservas()) {
                    if (espacio[posicion] == null) {
                        System.out.println(
                                "la persona " + visitante.getNombre() + " ocupa el lugar " + (posicion + 1)
                                        + " del area "
                                        + numero);
                        espacio[posicion] = visitante;
                    }
                    posicion++;
                    contador++;
                } else {
                    finalizado = true;
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fin de la reserva");
        if (this.cantEspaciosLibres() == 0) {
            System.out.println("se agotaron los espacios");
        }
    }
}
