package TP7.clases.ej2;

public class Programador implements Runnable {
    private int numero;
    private Computadora laComputadora;
    private Libro libroReferencia;

    public Programador(int n, Computadora laC, Libro elL) {
        numero = n;
        laComputadora = laC;
        libroReferencia = elL;
    }

    public void run() {
        System.out.println("el programador N° " + this.numero + " comienza a trabajar");
        while (true) {
            libroReferencia.usarLibro();
            System.out.println("el programador N° " + this.numero + " ocupa el libro de referencia");
            laComputadora.usarComputadora();
            System.out.println(
                    "el programador N° " + this.numero + " ocupa la computadora y empieza a escribir el codigo");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            libroReferencia.liberarLibro();
            laComputadora.liberarComputadora();
        }
    }
}
