package PC.TP3.Clases;

public class Jaula {
    private Hamaca miHamaca;
    private Rueda miRueda;
    private Plato miPlato;

    public Jaula(Hamaca ham, Rueda ru, Plato pla) {
        miHamaca = ham;
        miRueda = ru;
        miPlato = pla;
    }

    public void descansar(String nombre) {
        miHamaca.run(nombre);
    }

    public void jugar(String nombre) {
        miRueda.run(nombre);
    }

    public void comer(String nombre) {
        miPlato.run(nombre);
    }

}
