package PC.TP3;

public class Area {
    private int espacio;

    public Area(int es) {
        espacio = es;
    }

    public synchronized void reservar() {
        if (espacio > 0) {
            espacio--;
        }
    }
}
