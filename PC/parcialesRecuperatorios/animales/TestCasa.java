public class TestCasa {
    public static void main(String[] args) {
        Casa laCasa = new Casa();
        Thread hiloMayor = new Thread(new Mayor(laCasa));
        hiloMayor.start();
        for (int i = 1; i <= 10; i++) {
            Thread hiloAnimal = new Thread(new Animalito(i, laCasa));
            hiloAnimal.start();
        }
    }
}
