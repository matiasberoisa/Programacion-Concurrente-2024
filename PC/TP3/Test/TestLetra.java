package PC.TP3.Test;

import java.util.ArrayList;

import PC.TP3.Clases.Cadena;
import PC.TP3.Clases.Letra;

public class TestLetra {
    public static void main(String[] args) {
        ArrayList<Thread> hiloLetras = new ArrayList<Thread>();
        Cadena cadena = new Cadena();
        String[] simbolos = new String[3];
        Letra[] letras = new Letra[3];
        boolean terminado = false;
        int pos = 0;
        simbolos[0] = "A";
        simbolos[1] = "B";
        simbolos[2] = "C";
        for (int i = 0; i < 3; i++) {
            letras[i] = new Letra("hilo" + simbolos[i], simbolos[i], cadena);
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
        System.out.println(cadena.resultado());
    }
}
