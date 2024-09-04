package PC.TP3;

public class Hamaca {

    public synchronized void run(String nombre) {
        System.out.println(nombre + " usa la hamaca");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("la hamaca fue desocupada");

    }
}
