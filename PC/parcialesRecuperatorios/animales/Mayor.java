public class Mayor implements Runnable {
    private Casa laCasa;

    public Mayor(Casa laC) {
        laCasa = laC;
    }

    public void run() {
        System.out.println("el animal mayor ha cocinado");
        try {
            while (true) {
                if (laCasa.hayBancosOcupados() > 0) {
                    System.out.println("el mayor sirve comida a un animalito");
                    Thread.sleep(3000);
                    laCasa.servirComida();
                } else {
                    System.out.println("no hay animal esperando para comer");
                    System.out.println("el mayor se pone a dibujar");
                    laCasa.llevarComida();
                }
            }
        } catch (Exception e) {

        }
    }
}