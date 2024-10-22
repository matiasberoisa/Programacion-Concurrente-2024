package TP5.clases;

public class Mesa {
    private int numero;
    private String ordenComida;
    private String ordenBebida;

    public Mesa(int num, String oC, String oB) {
        numero = num;
        ordenComida = oC;
        ordenBebida = oB;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getOrdenComida() {
        return this.ordenComida;
    }

    public String getOrdenBebida() {
        return this.ordenBebida;
    }
}
