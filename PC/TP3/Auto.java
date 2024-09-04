package PC.TP3;

public class Auto implements Runnable {
    private String patente;
    private int modelo;
    private String marca;
    private int km;
    private int cantLitro;

    public Auto(String pa, int mo, String ma, int k, int cl) {
        patente = pa;
        modelo = mo;
        marca = ma;
        km = k;
        cantLitro = cl;
    }

    public void run() {

    }
}
