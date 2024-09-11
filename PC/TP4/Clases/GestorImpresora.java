package Clases;

public class GestorImpresora {
    private int numero;
    private String estado;

    public GestorImpresora(int num) {
        numero = num;
        estado = "disponible";
    }

    public int obtenerNumero() {
        return this.numero;
    }

    public String estado() {
        return this.estado;
    }

    public void usar() {
        this.estado = "ocupada";
    }

    public void liberar() {
        this.estado = "disponible";
    }
}
