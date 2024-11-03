package parcialesRecuperatorios.Embotelladora;

public class Embotellador implements Runnable {
    private int numero;
    private String tipo;
    private Fabrica laFabrica;

    public Embotellador(int n, String ti, Fabrica laF) {
        numero = n;
        tipo = ti;
        laFabrica = laF;
    }

    public void run() {
        try {
            while (true) {
                laFabrica.entraEmbotellador();
                if (laFabrica.existeCaja()) {
                    if (tipo.equals(laFabrica.tipoCaja())) {
                        laFabrica.prepararBotella();
                        System.out
                                .println("el embotellador N° " + this.numero + " prepara una botella de " + this.tipo
                                        + " cant cajas: " + laFabrica.cantCajas());
                        Thread.sleep(3000);

                    }
                }
                laFabrica.saleEmbotellador();
            }
        } catch (Exception e) {
        }

    }
}
