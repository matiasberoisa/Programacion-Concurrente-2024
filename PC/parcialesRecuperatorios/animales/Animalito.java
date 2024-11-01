import java.util.Random;

public class Animalito implements Runnable {
    private int numero;
    private Casa laCasa;
    private Random random = new Random();

    public Animalito(int n, Casa laC) {
        numero = n;
        laCasa = laC;
    }

    public void run() {
        try {
            System.out.println("el animal " + numero + " esta jugando");
            Thread.sleep(random.nextInt(0, 5) * 1000);
            laCasa.buscarBanco();
            System.out.println("el animal " + numero + " se sienta en un banco");
            laCasa.ocuparBanco();
            laCasa.comer();
            System.out.println("el animal " + numero + " empieza a comer");
            Thread.sleep(3000);
            System.out.println("el animal " + numero + " termina de comer y se va a jugar");
            laCasa.liberarBanco();
        } catch (Exception e) {

        }
    }
}
