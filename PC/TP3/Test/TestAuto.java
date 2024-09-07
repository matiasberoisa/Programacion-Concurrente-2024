package PC.TP3.Test;

import java.util.ArrayList;

import PC.TP3.Clases.Auto;
import PC.TP3.Clases.Surtidor;

public class TestAuto {
    public static void main(String[] args) {
        ArrayList<Thread> autos = new ArrayList<Thread>();
        Surtidor unSur = new Surtidor(20);
        for (int i = 0; i < 5; i++) {
            Thread hiloAuto = new Thread(new Auto("AAA " + 0 + (i + 1), i, "TOYOTA", i + 1, unSur));
            autos.add(hiloAuto);
        }
        autos.forEach(a -> a.start());
    }
}
