package PC.TP3.Clases;

public class Rueda {

    public synchronized void run(String nombre) {
        System.out.println(nombre + " usa la rueda");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("la rueda fue desocupada");

    }
}
