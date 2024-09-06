package PC.TP3;

import java.util.ArrayList;
import java.util.Random;

public class TestPersona {
    public static void main(String[] args) {
        ArrayList<Thread> personas = new ArrayList<Thread>();
        Area[] espacios = new Area[5];
        Random numRandom = new Random();
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = new Area(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            Thread hiloPersona = new Thread(new Persona(espacios, numRandom.nextInt(20, 30)));
            personas.add(hiloPersona);
        }
        personas.forEach(a -> a.start());
    }
}
