package TP3.Clases;

public class Mascotas implements Runnable {
    private String nombre;
    private Jaula miJaula;

    public Mascotas(String nn, Jaula jau) {
        nombre = nn;
        miJaula = jau;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        miJaula.descansar(this.nombre);
        miJaula.jugar(this.nombre);
        miJaula.comer(this.nombre);
    }

}
