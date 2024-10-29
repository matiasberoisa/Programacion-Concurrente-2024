package TP8.clases.ej4;

public class Donador implements Runnable {
    private int numero;
    private Centro hemoterapia;
    private boolean tomoRevista;
    private boolean tomoAsiento;
    private boolean deseaSentarse;

    public Donador(int num, Centro hemo, boolean ds) {
        numero = num;
        hemoterapia = hemo;
        tomoAsiento = false;
        tomoRevista = false;
        deseaSentarse = ds;
    }

    public void run() {
        boolean pasoCamilla;
        try {
            hemoterapia.entrarAlCentro();
            System.out.println("entra al centro el donador N° " + this.numero);
            pasoCamilla = hemoterapia.buscarCamilla(this);
            if (pasoCamilla) {
                hemoterapia.usarCamilla();
                System.out.println("el donador N° " + this.numero + " pasa a las camillas");
                Thread.sleep(3000);
                System.out.println("el donador N° " + this.numero + " termina de donar sangre y se retira del centro");
                hemoterapia.dejarCamilla();
            } else {
                if (tomoAsiento) {
                    if (!tomoRevista) {
                        tomarRevista();
                    }
                    hemoterapia.usarCamilla();
                    hemoterapia.dejarSilla();
                    hemoterapia.dejarRevista();
                } else {
                    if (!tomoRevista) {
                        tomarRevista();
                    }
                    hemoterapia.usarCamilla();
                    hemoterapia.dejarRevista();
                }
                System.out.println("el donador N° " + this.numero + " pasa a las camillas");
                Thread.sleep(3000);
                System.out.println("el donador N° " + this.numero + " termina de donar sangre y se retira del centro");
                hemoterapia.dejarCamilla();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tomarRevista() {
        tomoRevista = true;
    }

    public void tomarAsiento() {
        tomoAsiento = true;
    }

    public int getNumero() {
        return this.numero;
    }

    public boolean deseaSentarse() {
        return deseaSentarse;
    }
}
