package PC.TP5.clases;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore semaforoPerro;
    private Semaphore semaforoGato;
    private Semaphore semaforoFila = new Semaphore(1);
    private Plato[] comederos;

    public Comedor(Plato[] platos) {
        comederos = platos;
        semaforoPerro = new Semaphore(comederos.length);
        semaforoGato = new Semaphore(comederos.length);
    }

    public void buscarPlato(Animal unAnimal) {
        Plato unPlato = null;
        try {
            semaforoFila.acquire();
            System.out.println("entra " + unAnimal.getNombre() + " " + unAnimal.getNumero() + " a comer");
            System.out.println("revisa si hay un plato vacio");
            unPlato = this.comedorDisponible(unAnimal);
            this.entraGato(unPlato, unAnimal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entraGato(Plato unPlato, Animal unAnimal) {
        try {
            semaforoGato.acquire();
            semaforoFila.release();
            unPlato.entraAComer();
            System.out.println(
                    "entra " + unAnimal.getNombre() + " " + unAnimal.getNumero() + " al plato " + unPlato.getNumero());
            Thread.sleep(3000);
            unPlato.saleDeComer();
            semaforoGato.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entraPerro(Plato unPlato, Animal unAnimal) {
        try {
            semaforoPerro.acquire();
            semaforoFila.release();
            unPlato.entraAComer();
            System.out.println(
                    "entra " + unAnimal.getNombre() + " " + unAnimal.getNumero() + " al plato " + unPlato.getNumero());
            Thread.sleep(3000);
            unPlato.saleDeComer();
            semaforoPerro.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Plato comedorDisponible(Animal unAnimal) {
        Plato libre = null;
        int pos = 0;
        while (pos < comederos.length && libre == null) {
            if (comederos[pos].getCantidad() < comederos[pos].getLimite()) {
                libre = comederos[pos];
            }
            pos++;
        }
        return libre;
    }
}
