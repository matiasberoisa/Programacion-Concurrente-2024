package PC.TP3.Clases;

public class Area {
    private Persona[] espacio;
    private int posicion;
    private int numero;

    public Area(int num) {
        espacio = new Persona[50];
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
        int i = 0, cant = 0;
        while (i < espacio.length) {
            if (espacio[i] == null) {
                cant++;
            }
            i++;
        }
        return cant;
    }

    public void reservar(Persona visitante) {
        int contadorPosiciones = 0;
        try {
            while (espacio[posicion] != null) {
                contadorPosiciones++;
            }
            while (posicion < espacio.length && posicion < (visitante.getCantReservas() + contadorPosiciones)) {
                if (espacio[posicion] == null) {
                    System.out.println(
                            "la persona " + visitante.getNombre() + " ocupa el lugar " + (posicion + 1)
                                    + " del area "
                                    + numero);
                    espacio[posicion] = null;
                    posicion++;
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fin de la reserva");
    }
}
