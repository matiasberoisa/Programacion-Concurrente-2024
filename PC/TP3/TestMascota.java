package PC.TP3;

import java.util.ArrayList;

public class TestMascota {

    public static void main(String[] args) {
        ArrayList<Thread> animales = new ArrayList<Thread>();
        Jaula laJaula = new Jaula(new Hamaca(), new Rueda(), new Plato());
        for (int i = 0; i < 6; i++) {
            Thread hiloHamster = new Thread(new Mascotas("Hamster #" + (i + 1), laJaula));
            animales.add(hiloHamster);
        }
        animales.forEach(a -> a.start());
    }
}
