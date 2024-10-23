package TP5.clases.ej6;

public class Torre implements Runnable {
    private Pista laPista;

    public Torre(Pista laP) {
        laPista = laP;
    }

    public void run() {
        while (true) {

            laPista.habilitarTorre();
            System.out.println("//////////TOPE, SE CAMBIA LA CONDICION DE ATERRIZAJE A DESPEGUE//////////");
            laPista.priorizarDespegue();
            laPista.habilitarTorre();
            System.out.println("//////////SE CAMBIA LA CONDICION DE DESPEGUE A ATERRIZAJE//////////");
        }
    }
}
