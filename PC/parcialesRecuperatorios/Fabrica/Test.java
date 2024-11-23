package parcialesRecuperatorios.Fabrica;

public class Test {
    public static void main(String[] args) {
        Fabrica laFabrica = new Fabrica(10, 10, 10);
        Thread hiloEnsamblador = new Thread(new GrupoEnsamblador(laFabrica));
        hiloEnsamblador.start();
        for (int i = 1; i <= 5; i++) {
            Thread hiloRueda = new Thread(new GrupoRueda(laFabrica, i));
            hiloRueda.start();
            Thread hiloPuerta = new Thread(new GrupoPuerta(laFabrica, i));
            hiloPuerta.start();
            Thread hiloCarroceria = new Thread(new GrupoCarroceria(laFabrica, i));
            hiloCarroceria.start();
        }
    }
}
