package Clases;

public class Impresora {
    private int numero;
    private String tipoImpresora;
    private String estado;

    public Impresora(int num, String ti) {
        numero = num;
        tipoImpresora = ti;
        estado = "disponible";
    }

    public int obtenerNumero() {
        return this.numero;
    }

    public String estado() {
        return this.estado;
    }

    public String obtenerTipo() {
        return this.tipoImpresora;
    }

    public synchronized void usar(Cliente unCliente) throws InterruptedException {
        System.out.println("el cliente " + unCliente.obtenerNombre() + " usa la impresora " + this.numero + ", tipo "
                + this.tipoImpresora);
        this.estado = "ocupada";
    }

    public synchronized void liberar(Cliente unCliente) throws InterruptedException {
        System.out.println("el cliente " + unCliente.obtenerNombre() + " libera la impresora " + this.numero + ", tipo "
                + this.tipoImpresora);
        this.estado = "disponible";
    }
}
