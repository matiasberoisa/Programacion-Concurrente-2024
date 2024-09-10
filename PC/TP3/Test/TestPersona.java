package PC.TP3.Test;

import java.util.ArrayList;
import java.util.Random;

import PC.TP3.Clases.Area;
import PC.TP3.Clases.Persona;

public class TestPersona {
    public static void main(String[] args) {
        ArrayList<Thread> personas = new ArrayList<Thread>();
        // Area[] espacios = new Area[2];
        Random numRandom = new Random();
        Area espacio = new Area(1);
        /*
         * for (int i = 0; i < espacios.length; i++) {
         * espacios[i] = new Area(i + 1);
         * }
         */
        for (int i = 0; i < 5; i++) {
            Thread hiloPersona = new Thread(new Persona(espacio, numRandom.nextInt(20, 30)));
            personas.add(hiloPersona);
        }
        personas.forEach(a -> a.start());
    }
}
