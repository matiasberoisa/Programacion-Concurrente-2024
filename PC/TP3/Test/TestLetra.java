package PC.TP3.Test;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import PC.TP3.Clases.Letra;

public class TestLetra {
    public static void main(String[] args) {
        ArrayList<Thread> hiloLetras = new ArrayList<Thread>();
        String cadena = "";
        Semaphore sem1 = new Semaphore(1);
        String[] letras = new String[3];
        letras[0] = "A";
        letras[1] = "B";
        letras[2] = "C";
        for (int i = 0; i < 3; i++) {
            Thread hiloLetra = new Thread(
                    new Letra("hilo" + letras[i], letras[i], cadena, sem1));
            hiloLetras.add(hiloLetra);
        }
        hiloLetras.forEach(a -> a.start());
    }
}
