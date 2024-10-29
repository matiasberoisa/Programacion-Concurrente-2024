package TP8.clases.ej1;

public class Soldado implements Runnable {
    private int numero;
    private Recinto elRecinto;
    private String tipoBebida;
    private String quierePostre;

    public Soldado(int num, Recinto elR, String tb, String postre) {
        numero = num;
        elRecinto = elR;
        tipoBebida = tb;
        quierePostre = postre;
    }

    public void run() {
        try {
            tomarBandejas();
            System.out.println("el soldado N° " + this.numero + " empieza a comer");
            Thread.sleep(5000);
            dejarBandejas();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tomarBandejas() {
        try {
            elRecinto.entrarFila();
            System.out.println("el soldado N° " + this.numero + " llega a los mostradores");
            elRecinto.tomarBandeja();
            Thread.sleep(3000);
            System.out.println("el soldado N° " + this.numero + " toma una bandeja");
            elRecinto.dejarFila();
            System.out.println("el soldado N° " + this.numero + " escogio " + this.tipoBebida);
            if (tipoBebida.equals("gaseosa")) {
                elRecinto.tomarAbridor();
                System.out.println("el soldado N° " + this.numero + " toma un abridor");
                Thread.sleep(3000);
            }
            System.out.println("el soldado N° " + this.numero + " " + this.quierePostre + " quiere postre");
            if (quierePostre.equals("SI")) {
                elRecinto.tomarPostre();
                System.out.println("el soldado N° " + this.numero + " toma un postre");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void dejarBandejas() {
        try {
            System.out.println("el soldado N° " + this.numero + " deja la bandeja");
            elRecinto.dejarBandeja();
            Thread.sleep(1000);
            if (tipoBebida.equals("gaseosa")) {
                System.out.println("el soldado N° " + this.numero + " deja el abridor");
                elRecinto.dejarAbridor();
                Thread.sleep(1000);
            }
            if (quierePostre.equals("SI")) {
                System.out.println("el soldado N° " + this.numero + " deja el postre");
                elRecinto.dejarPostre();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
