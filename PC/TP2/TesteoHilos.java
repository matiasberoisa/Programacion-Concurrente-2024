package PC.TP2;

public class TesteoHilos {
    public static void main (String[] args){
        Thread miHilo= new MiEjecucion();
        miHilo.run();
        System.out.println("En el main");
        // se cambia start por run, para que el hilo se ejecute primero
        }
}
