package parcialesRecuperatorios.Embotelladora;

public class TestFabrica {
    public static void main(String[] args) {
        Fabrica laFabrica = new Fabrica();
        Thread hiloEmpaquetador = new Thread(new Empaquetador(laFabrica));
        hiloEmpaquetador.start();
        Thread hiloTransportador = new Thread(new Transportador(laFabrica));
        hiloTransportador.start();
        for (int i = 1; i <= 5; i++) {
            Thread hiloVino = new Thread(new Embotellador(i, "Vino", laFabrica));
            Thread hiloAgua = new Thread(new Embotellador(i, "Agua", laFabrica));
            hiloVino.start();
            hiloAgua.start();
        }
    }
}
