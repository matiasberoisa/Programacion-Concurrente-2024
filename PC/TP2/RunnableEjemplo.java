package TP2;

public class RunnableEjemplo implements Runnable {

    private String cadena;

    public RunnableEjemplo(String str) {
        this.cadena = str;
    }

    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(i + " " + this.cadena);
        System.out.println("Termina thread " + this.cadena);
    }

    public static void main(String[] args) {
        RunnableEjemplo hilo1 = new RunnableEjemplo("Maria Jose");
        RunnableEjemplo hilo2 = new RunnableEjemplo("Jose Maria");
        Thread primerHilo = new Thread(hilo1);
        Thread segundoHilo = new Thread(hilo2);
        primerHilo.start();
        segundoHilo.start();
        System.out.println("Termina thread main");
    }
}