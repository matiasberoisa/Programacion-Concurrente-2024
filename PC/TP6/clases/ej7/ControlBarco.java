package TP6.clases.ej7;

public class ControlBarco implements Runnable {
    private Barco elBarco;

    public ControlBarco(Barco elB) {
        elBarco = elB;
    }

    public void run() {
        System.out.println("el control comienza a trabajar");
        try {
            while (true) {
                System.out.println("//////////SE HABILITA LA SUBIDA, LOS OBJETOS PUEDEN SUBIR AL BARCO//////////");
                elBarco.habilitarSubida();
                elBarco.subieronTodos();
                System.out.println("//////////SALE EL BARCO//////////");
                Thread.sleep(5000);
                System.out.println("//////////LLEGA EL BARCO//////////");
                elBarco.terminar();
                System.out.println("//////////SE HABILITA LA BAJADA, LOS OBJETOS PUEDEN BAJAR DEL BARCO//////////");
                elBarco.habilitarBajada();
                elBarco.bajaronTodos();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
