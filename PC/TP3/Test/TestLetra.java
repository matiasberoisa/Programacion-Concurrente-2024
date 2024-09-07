package PC.TP3.Test;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import PC.TP3.Clases.Letra;

public class TestLetra {
    public static void main(String[] args) {
        ArrayList<Thread> hiloLetras = new ArrayList<Thread>();
        String cadena = "";
        Semaphore sem1 = new Semaphore(1);
        String[] simbolos = new String[3];
        Letra[] letras = new Letra[3];
        boolean terminado = false;
        int pos = 0;
        simbolos[0] = "A";
        simbolos[1] = "B";
        simbolos[2] = "C";
        for (int i = 0; i < 3; i++) {
            letras[i] = new Letra("hilo" + simbolos[i], simbolos[i], cadena, sem1);
            Thread hiloLetra = new Thread(letras[i]);
            hiloLetras.add(hiloLetra);
        }
        hiloLetras.forEach(a -> a.start());
        while (!terminado) {
            if (pos < letras.length) {
                if (letras[pos].termino()) {
                    pos++;
                }
            } else {
                terminado = true;
            }
        }
    }
}
