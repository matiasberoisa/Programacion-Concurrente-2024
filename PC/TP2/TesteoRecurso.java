package PC.TP2;

public class TesteoRecurso {
    public static void main(String[] args) {
        Cliente1 juan = new Cliente1();
        juan.setName("Juan Lopez");
        Cliente1 ines = new Cliente1();
        ines.setName("Ines Garcia");
        ines.start();
        juan.start();
        // participan 2 hilos
        // si se agrega recurso.uso() se ejecuta el main como un hilo
    }
}
