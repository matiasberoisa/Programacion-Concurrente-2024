package ejemplosPC2023;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nestor Diaz
 */
public class Gato implements Runnable {
    Comedor comedor;

    public Gato(Comedor unComedor) {
        comedor = unComedor;
    }// Fin contructor

    @Override
    public void run() {
        try {
            comedor.entraGato();
            comedor.SalaEsperaGato();
            comedor.ComeGato();
            Thread.sleep(3100);
            comedor.SaleGato();
            Thread.sleep(3100);

        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// Fin Run
}
