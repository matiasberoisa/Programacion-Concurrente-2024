/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosPC2023;

/**
 *
 * @author nestor.diaz
 */
public class MainComedor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread[] hilosG = new Thread[10];
        Thread[] hilosP = new Thread[3];

        Comedor comedor = new Comedor(3, 5);

        for (int i = 0; i < 3; i++) {
            Perro perro = new Perro(comedor);
            hilosP[i] = new Thread(perro, "Perro_" + i);
            hilosP[i].start();
        } // Fin del for

        for (int i = 0; i < 10; i++) {
            Gato gato = new Gato(comedor);
            hilosG[i] = new Thread(gato, "Gato_" + i);
            hilosG[i].start();

        } // Fin del for

    }

}
