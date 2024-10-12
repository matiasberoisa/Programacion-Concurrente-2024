package TP3.Clases;

public class Plato {

    public synchronized void run(String nombre) {
        System.out.println(nombre + " usa el plato");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("el plato fue desocupado");
    }

}
