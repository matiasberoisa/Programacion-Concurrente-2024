package parcialesRecuperatorios.pelicula;

public class Test {
    public static void main(String[] args) {
        Pelicula laPelicula = new Pelicula();
        Thread hiloFilmador = new Thread(new Filmador(laPelicula));
        hiloFilmador.start();
        Thread hiloTraductorUno = new Thread(new Traductor(1, laPelicula));
        Thread hiloTraductoDos = new Thread(new Traductor(2, laPelicula));
        hiloTraductorUno.start();
        hiloTraductoDos.start();
        for (int i = 1; i <= 10; i++) {
            Thread hiloEspañol = new Thread(new Socio(laPelicula, i, "Español"));
            Thread hiloIngles = new Thread(new Socio(laPelicula, i, "Ingles"));
            hiloEspañol.start();
            hiloIngles.start();
        }
    }
}
