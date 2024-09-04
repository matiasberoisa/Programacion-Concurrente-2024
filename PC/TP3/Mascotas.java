package PC.TP3;

import java.util.ArrayList;

public class Mascotas {
    private String nombre;

    public Mascotas(String nn) {
        nombre = nn;
    }

    public String getNombre() {
        return this.nombre;
    }

    public static void main(String[] args) {
        ArrayList<Runnable> objetos = new ArrayList<Runnable>();
        ArrayList<Thread> animales = new ArrayList<Thread>();
        Hamaca hamaca = new Hamaca();
        Plato plato = new Plato();
        Rueda rueda = new Rueda();
        objetos.add(hamaca);
        objetos.add(plato);
        objetos.add(rueda);
        for (int i = 0; i < 6; i++) {
            Thread hiloHamster = new Thread("Hamster#" + (i + 1));
            animales.add(hiloHamster);
        }
        objetos.forEach(obj -> obj.run());
    }
}
