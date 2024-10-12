package TP2;

public class Recurso {
    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy" + t.getName());
        // uso es un metodo que imprime el hilo
    }
}
