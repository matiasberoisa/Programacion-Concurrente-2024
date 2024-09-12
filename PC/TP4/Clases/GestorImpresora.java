package Clases;

public class GestorImpresora {
    private Impresora[] impresoras;
    private Impresora[] impresoras2;
    private int posicion;

    public GestorImpresora(Impresora[] imp) {
        impresoras = imp;
        posicion = 0;
    }

    public GestorImpresora(Impresora[] imp1, Impresora[] imp2) {
        impresoras = imp1;
        impresoras2 = imp2;
        posicion = 0;
    }

    public synchronized Impresora buscarDisponible() {
        int pos = 0;

        while (!impresoras[posicion].estado().equals("disponible") && posicion < impresoras.length - 1) {
            posicion++;
        }
        pos = posicion;
        if (posicion == impresoras.length - 1) {
            posicion = 0;
        }
        return this.impresoras[pos];
    }

    public int getTamaño() {
        return this.impresoras.length;
    }
}
