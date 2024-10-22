package TP7.clases.ej4;

public class Cocineros implements Runnable {
    private String tipo;
    private Cocina laCocina;
    private boolean tieneIngrediente;

    public Cocineros(String ti, Cocina laC) {
        tipo = ti;
        laCocina = laC;
        tieneIngrediente = false;
    }

    public void run() {
        System.out.println("el cocinero de " + this.tipo + " comienza a trabajar");
        while (true) {
            try {
                laCocina.usarCocina();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.obtieneIngrediente();

            System.out.println("el cocinero de " + this.tipo + " obtiene el ingrediente y comienza a cocinar");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.agotaIngrediente();
            System.out.println("el cocinero de " + this.tipo + " termina a cocinar");
            laCocina.liberarCocina();
        }
    }

    public void obtieneIngrediente() {
        tieneIngrediente = true;
    }

    public void agotaIngrediente() {
        tieneIngrediente = false;
    }

    public boolean ingrediente() {
        return this.tieneIngrediente;
    }
}
