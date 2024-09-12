package Clases;

public class Impresora {
    private int numero;
    private String estado;

    public Impresora(int num) {
        numero = num;
        estado = "disponible";
    }

    public int obtenerNumero() {
        return this.numero;
    }

    public String estado() {
        return this.estado;
    }

    public synchronized void usar(Cliente unCliente) throws InterruptedException {
        System.out.println("el cliente " + unCliente.obtenerNombre() + " usa la impresora " + this.numero);
        this.estado = "ocupada";
    }

    public synchronized void liberar(Cliente unCliente) throws InterruptedException {
        System.out.println("el cliente " + unCliente.obtenerNombre() + " libera la impresora " + this.numero);
        this.estado = "disponible";
    }
}
