package parcialesRecuperatorios.pelicula;

public class Socio implements Runnable {
    private Pelicula laPelicula;
    private int numero;
    private int capitulosVistos;
    private String idioma;

    public Socio(Pelicula laP, int n, String i) {
        laPelicula = laP;
        numero = n;
        capitulosVistos = 0;
        idioma = i;
    }

    public void run() {
        try {
            while (true) {
                if (idioma.equals("Español")) {
                    this.mirarEspañol();
                } else {
                    this.mirarIngles();
                }
            }
        } catch (Exception e) {

        }
    }

    public void mirarEspañol() throws InterruptedException {
        laPelicula.mirarCapituloEspañol(capitulosVistos);
        System.out.println("el socio N° " + this.numero + " esta mirando un capitulo en " + this.idioma);
        Thread.sleep(5000);
        System.out.println("el socio N° " + this.numero + " termino un capitulo en " + this.idioma);
        capitulosVistos++;
        laPelicula.terminarCapitulo();
    }

    public void mirarIngles() throws InterruptedException {
        laPelicula.mirarCapituloIngles(capitulosVistos);
        System.out.println("el socio N° " + this.numero + " esta mirando un capitulo " + this.idioma);
        Thread.sleep(5000);
        System.out.println("el socio N° " + this.numero + " termino un capitulo en " + this.idioma);
        capitulosVistos++;
        laPelicula.habilitarTraductor();
    }
}
