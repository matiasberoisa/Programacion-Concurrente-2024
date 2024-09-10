package PC.TP3.Clases;

import java.util.Random;

public class Letra implements Runnable {
    private String nombre;
    private String letra;
    private int cantidad;
    private Random numRandom = new Random();
    private Cadena cadena;
    private boolean termino = false;

    public Letra(String nn, String le, Cadena ca) {
        nombre = nn;
        letra = le;
        cantidad = numRandom.nextInt(1, 5);
        cadena = ca;
    }

    public void run() {
        String valor = "";
        for (int i = 0; i < cantidad; i++) {
            valor = valor + letra;
        }
        System.out.println(this.nombre + " concatena " + valor);
        cadena.concatenar(cantidad, this);
        System.out.println(this.nombre + " termina de concatenar");
        termino = true;
    }

    public boolean termino() {
        return this.termino;
    }

    public String obtenerLetra() {
        return this.letra;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

}
