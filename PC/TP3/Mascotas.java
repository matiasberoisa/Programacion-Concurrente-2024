package PC.TP3;

import java.util.ArrayList;

public class Mascotas {
    private String nombre;
    private int objUsados;

    public Mascotas(String nn) {
        nombre = nn;
        objUsados = 0;
    }

    public void usoElemento() {
        objUsados += 1;
    }

    public int elementosUsados() {
        return this.objUsados;
    }

    public String getNombre() {
        return this.nombre;
    }

    public static void main(String[] args) {
        Thread[] objetos = new Thread[3];
        ArrayList<Jaula> animales = new ArrayList<Jaula>();
        Thread hiloHamaca = new Thread(new Hamaca());
        Thread hiloPlato = new Thread(new Plato());
        Thread hiloRueda = new Thread(new Rueda());
        objetos[0] = hiloHamaca;
        objetos[1] = hiloPlato;
        objetos[2] = hiloRueda;
        for (int i = 0; i < 6; i++) {
            Jaula hiloHamster = new Jaula(objetos, new Mascotas("Hamster#" + (i + 1)));
            animales.add(hiloHamster);
        }
        animales.forEach(a -> a.start());
    }
}
