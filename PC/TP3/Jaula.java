package PC.TP3;

public class Jaula extends Thread {
    private Thread[] objetos;
    private Mascotas hamster;

    public Jaula(Thread[] obj, Mascotas ham) {
        objetos = obj;
        hamster = ham;
    }

    public void run() {

    }
}
