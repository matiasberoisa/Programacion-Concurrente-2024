package parcialesRecuperatorios.Exposicion;

public class TestExpo {
    public static void main(String[] args) {
        Sala laSala = new Sala(10);
        for (int i = 1; i <= 30; i++) {
            Thread hiloVisitante = new Thread(new Visitante(i, laSala));
            Thread hiloResponsable = new Thread(new Responsable(i, laSala));
            Thread hiloCritico = new Thread(new Critico(i, laSala));
            hiloCritico.start();
            hiloResponsable.start();
            hiloVisitante.start();
        }
    }
}
