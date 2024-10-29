package TP8.clases.ej2;

public class PersonalMantenimiento implements Runnable {
    private Observatorio elObservatorio;
    private int numero;

    public PersonalMantenimiento(Observatorio elObs, int num) {
        elObservatorio = elObs;
        numero = num;
    }

    public void run() {
        while (true) {
            try {
                elObservatorio.entraPersonal();
                System.out.println("el empleado " + this.numero + " entra a limpiar el observatorio");
                Thread.sleep(5000);
                System.out.println("el empleado " + this.numero + " deja el observatorio");
                elObservatorio.salePersonal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumero() {
        return this.numero;
    }
}
