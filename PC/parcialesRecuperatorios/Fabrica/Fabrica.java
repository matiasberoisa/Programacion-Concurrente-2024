package parcialesRecuperatorios.Fabrica;

import java.util.concurrent.Semaphore;

public class Fabrica {
    private Semaphore lineaRueda, lineaPuerta, lineaCarroceria, ruedas, puertas, carroceria;
    private int contadorRuedas, contadorPuertas, contadorCarroceria, contadorAutos, capacidadRuedas, capacidadPuertas,
            capacidadCarrocerias;

    public Fabrica(int capRueda, int capPuerta, int capCarroceria) {
        lineaRueda = new Semaphore(1);
        lineaPuerta = new Semaphore(1);
        lineaCarroceria = new Semaphore(1);
        ruedas = new Semaphore(0);
        puertas = new Semaphore(0);
        carroceria = new Semaphore(0);
        contadorRuedas = 0;
        contadorPuertas = 0;
        contadorCarroceria = 0;
        capacidadRuedas = capRueda;
        capacidadPuertas = capPuerta;
        capacidadCarrocerias = capCarroceria;
    }

    public void entrarLineaRueda() {
        try {
            lineaRueda.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entrarLineaPuerta() {
        try {
            lineaPuerta.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entrarLineaCarroceria() {
        try {
            lineaCarroceria.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salirLineaRueda() {
        lineaRueda.release();
    }

    public void salirLineaPuerta() {
        lineaPuerta.release();
    }

    public void salirLineaCarroceria() {
        lineaCarroceria.release();
    }

    public boolean producirRueda() {
        boolean sePuede = false;
        if (contadorRuedas < capacidadRuedas) {
            contadorRuedas++;
            ruedas.release();
        }

        return sePuede;
    }

    public boolean producirPuerta() {
        boolean sePuede = false;
        if (contadorPuertas < capacidadPuertas) {
            contadorPuertas++;
            puertas.release();
        }

        return sePuede;

    }

    public boolean producirCarroceria() {
        boolean sePuede = false;
        if (contadorCarroceria < capacidadCarrocerias) {
            contadorCarroceria++;
            carroceria.release();
        }

        return sePuede;

    }

    public void ensamblar() {
        try {
            ruedas.acquire(4);
            puertas.acquire(2);
            carroceria.acquire();
            contadorRuedas -= 4;
            contadorPuertas -= 2;
            contadorCarroceria--;
            contadorAutos++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean empaquetar() {
        boolean sePuede = false;
        if (contadorAutos == 5) {
            sePuede = true;
            contadorAutos = 0;
        }
        return sePuede;
    }
}
