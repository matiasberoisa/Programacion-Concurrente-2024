package parcialesRecuperatorios.pelicula;

public class Filmador implements Runnable {
    private Pelicula laPelicula;

    public Filmador(Pelicula laP) {
        laPelicula = laP;
    }

    public void run() {
        try {
            while (true) {
                laPelicula.filmarCapitulo();
                System.out.println("el filmador esta filmando un capitulo");
                Thread.sleep(5000);
                System.out.println("el filmador termino de filmar un capitulo");
            }
        } catch (Exception e) {

        }
    }
}
