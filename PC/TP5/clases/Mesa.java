package TP5.clases;

public class Mesa {
    private int numero;
    private String ordenComida;
    private String ordenBebida;
    private int tipoOrden;

    public Mesa(int num, String oC, String oB, int ti) {
        numero = num;
        ordenComida = oC;
        ordenBebida = oB;
        tipoOrden = ti;
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

    public int getTipoOrden() {
        return this.tipoOrden;
    }
}
