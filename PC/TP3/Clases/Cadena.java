package PC.TP3.Clases;

public class Cadena {
    private String cadena;

    public Cadena() {
        cadena = "";
    }

    public synchronized void concatenar(int cantidad, Letra unaLetra) {

        boolean empiezaHiloA = false, empiezaHiloB = false, empiezaHiloC = false;
        if (unaLetra.obtenerNombre().equals("hiloA")) {
            empiezaHiloA = true;
        }
        if (unaLetra.obtenerNombre().equals("hiloB") && empiezaHiloA) {
            empiezaHiloB = true;
        }
        if (unaLetra.obtenerNombre().equals("hiloB") && empiezaHiloB) {
            empiezaHiloC = true;
        }
        try {
            for (int i = 0; i < cantidad; i++) {
                if (empiezaHiloA) {
                    if (empiezaHiloB) {
                        if (empiezaHiloC) {
                            cadena += unaLetra.obtenerLetra();
                            Thread.sleep(1000);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String resultado() {
        return this.cadena;
    }
}
