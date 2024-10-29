package TP8.tests;

import java.util.Random;

import TP8.clases.ej2.*;

public class TestObservatorio {
    public static void main(String[] args) {
        Observatorio elObservatorio = new Observatorio(5);
        boolean[] discapacitado = new boolean[2];
        Random random = new Random();
        discapacitado[0] = true;
        discapacitado[1] = false;
        for (int i = 1; i <= 10; i++) {
            Thread hiloPersonal = new Thread(new PersonalMantenimiento(elObservatorio,
                    i));
            Thread hiloInvestigador = new Thread(new Investigador(elObservatorio, i));
            hiloPersonal.start();
            hiloInvestigador.start();
        }
        for (int i = 1; i <= 200; i++) {
            Thread hiloVisitante = new Thread(new Visitante(elObservatorio, i, discapacitado[random.nextInt(0, 2)]));
            hiloVisitante.start();
        }
    }
}
