package PC.TP3.Clases;

public class Cadena {
    private String cadena;
    private int posicion;
    private boolean disponible;

    public Cadena() {
        cadena = "";
        posicion = 1;
    }

    public synchronized void concatenar(int cantidad, Letra unaLetra) {
        int pos = 0;
        try {
            if (unaLetra.obtenerTurno() == posicion) {
                while (pos < cantidad) {
                    cadena += unaLetra.obtenerLetra();
                    Thread.sleep(1000);
                    pos++;
                }
                posicion++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String resultado() {
        return this.cadena;
    }

    public boolean disponible() {
        return this.disponible;
    }
}
