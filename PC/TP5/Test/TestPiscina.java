package PC.TP5.Test;

import PC.TP5.clases.*;

public class TestPiscina {
    public static void main(String[] args) {
        Piscina laPiscina = new Piscina(3);
        while (true) {
            Thread hiloPersona = new Thread(new Persona(laPiscina));
            hiloPersona.start();
        }
    }

}