package PC.TP2;

public class TesteoRecurso {
    public static void main (String[] args){
    Cliente juan=new Cliente();
    juan.setName("Juan Lopez");
    Cliente ines=new Cliente ();
    ines.setName ("Ines Garcia");
    ines.start();
    juan.start();
// participan 2 hilos
// si se agrega recurso.uso() se ejecuta el main como un hilo
    }
    }
