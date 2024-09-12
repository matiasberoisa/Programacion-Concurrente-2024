package Clases;

public class GestorImpresora {
    private Impresora[] impresoras;
    private int posicion;

    public GestorImpresora(Impresora[] imp, int cant) {
        impresoras = imp;
        posicion = 0;
    }

    public Impresora buscarDisponible() {
        int pos = 0;
        while (!impresoras[posicion].estado().equals("disponible") && posicion < impresoras.length) {
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
