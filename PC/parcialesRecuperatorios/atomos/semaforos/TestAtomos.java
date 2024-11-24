package parcialesRecuperatorios.atomos.semaforos;

public class TestAtomos {
    public static void main(String[] args) {
        Recipiente elRecipiente = new Recipiente(5);
        int i = 1;
        while (true) {
            Thread hiloOxigeno = new Thread(new Oxigeno(elRecipiente, i));
            hiloOxigeno.start();
            Thread hiloHidrogeno = new Thread(new Hidrogeno(elRecipiente, i));
            hiloHidrogeno.start();
            i++;
        }
    }
}
