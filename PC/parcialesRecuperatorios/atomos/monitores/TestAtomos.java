package parcialesRecuperatorios.atomos.monitores;

public class TestAtomos {
    public static void main(String[] args) {
        Recipiente elRecipiente = new Recipiente(30);
        int i = 0;
        while (i <= 10) {
            Thread hiloOxigeno = new Thread(new Oxigeno(elRecipiente));
            Thread hiloHidrogeno = new Thread(new Hidrogeno(elRecipiente));
            hiloHidrogeno.start();
            hiloOxigeno.start();
        }
    }
}
