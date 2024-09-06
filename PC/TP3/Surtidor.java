package PC.TP3;

public class Surtidor {
    private int maximo;

    public Surtidor(int max) {
        maximo = max;
    }

    public void llenarAuto(Auto unAuto, int litros) {
        this.maximo -= litros;
        unAuto.llenarTanque(litros);
    }

    public synchronized void cargarAuto(Auto unAuto, int litros) {
        if (maximo > 0) {
            System.out.println("el auto " + unAuto.getPatente() + " entra al surtidor");
            this.llenarAuto(unAuto, litros);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("el auto " + unAuto.getPatente() + " termina de conducir y continua conduciendo");
        } else {
            System.out.println("el surtidor no tiene nafta, el auto " + unAuto.getPatente() + " no cargo nafta");
        }

    }
}
