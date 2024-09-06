package PC.TP3;

import java.util.ArrayList;

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
