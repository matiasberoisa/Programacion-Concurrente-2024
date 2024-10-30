package TP8.tests;

import TP8.clases.ej5.*;

public class TestOlla {
    public static void main(String[] args) {
        Olla laOlla = new Olla();
        Thread hiloCocinero = new Thread(new Cocinero(laOlla));
        hiloCocinero.start();
        int i = 1;
        while (true) {
            Thread hiloCanibal = new Thread(new Canibal(i, laOlla));
            hiloCanibal.start();
            i++;
        }
    }
}
