package Clases;

import java.util.concurrent.Semaphore;

public class GestorImpresora {
    private Impresora[] impresorasA;
    private Impresora[] impresorasB;
    private int posicionA;
    private int posicionB;
    private Semaphore semaforoBuscar = new Semaphore(1);

    public GestorImpresora(Impresora[] imp1, Impresora[] imp2) {
        impresorasA = imp1;
        impresorasB = imp2;
        posicionA = 0;
        posicionB = 0;
    }

    public Impresora buscarDisponibleTipo(String tipo) {
        int pos = 0;
        Impresora disponible = null;
        try {
            semaforoBuscar.acquire();
            if (tipo.equals("A")) {
                while (!impresorasA[posicionA].estado().equals("disponible") && posicionA < impresorasA.length - 1) {
                    posicionA++;
                }
                pos = posicionA;
                if (posicionA == impresorasA.length - 1) {
                    posicionA = 0;
                }
                disponible = impresorasA[pos];
            }
            if (tipo.equals("B")) {
                while (!impresorasB[posicionB].estado().equals("disponible") && posicionB < impresorasB.length - 1) {
                    posicionB++;
                }
                pos = posicionB;
                if (posicionB == impresorasB.length - 1) {
                    posicionB = 0;
                }
                disponible = impresorasB[pos];
            }
            semaforoBuscar.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return disponible;
    }

}
