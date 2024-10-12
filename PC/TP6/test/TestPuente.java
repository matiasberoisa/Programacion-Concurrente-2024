package PC.TP6.test;

import PC.TP6.clases.*;

public class TestPuente {
    public static void main(String[] args) {
        Carril puente = new Carril();
        Thread hiloControl = new Thread(new ControlCarril());
        hiloControl.start();
        for (int i = 1; i <= 6; i++) {
            Thread hiloAutoNorte = new Thread(new Coche(i, "Norte", puente));
            Thread hiloAutoSur = new Thread(new Coche(i, "Sur", puente));
            hiloAutoNorte.start();
            hiloAutoSur.start();
        }
    }
}
