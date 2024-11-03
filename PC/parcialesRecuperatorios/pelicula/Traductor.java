package parcialesRecuperatorios.pelicula;

public class Traductor implements Runnable {
    private int numero;
    private Pelicula laPelicula;

    public Traductor(int n, Pelicula laP) {
        numero = n;
        laPelicula = laP;
    }

    public void run() {
        try {
            while (true) {
                laPelicula.traducirCapitulo();
                System.out.println("el traductor N° " + this.numero + " esta traduciendo un capitulo");
                Thread.sleep(8000);
                System.out.println("el traductor N° " + this.numero + " termino la traduccion y publica el capitulo");
                laPelicula.publicarTraduccion();
            }
        } catch (Exception e) {
        }
    }
}
