package TP8.tests;

import TP8.clases.ej2.*;

public class TestObservatorio {
    public static void main(String[] args) {
        Observatorio elObservatorio = new Observatorio(50, 3, 3);
        /*
         * for (int i = 1; i <= 3; i++) {
         * Thread hiloPersonal = new Thread(new PersonalMantenimiento(elObservatorio,
         * i));
         * Thread hiloInvestigador = new Thread(new Investigador(elObservatorio, i));
         * hiloPersonal.start();
         * hiloInvestigador.start();
         * }
         */
        for (int i = 1; i <= 200; i++) {
            Thread hiloVisitante = new Thread(new Visitante(elObservatorio, i, false));
            hiloVisitante.start();
        }
    }
}
