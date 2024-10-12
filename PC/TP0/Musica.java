package TP0;

public class Musica {
    static void afinar(Instrumento i) {
        i.tocar();
    }

    static void afinarTodo(Instrumento[] e) {
        for (int i = 0; i < e.length; i++) {
            afinar(e[i]);
        }

    }

    public static void main(String[] args) {
        Instrumento[] orquesta = new Instrumento[5];
        int i = 0;
        orquesta[i++] = new Guitarra();
        orquesta[i++] = new Piano();
        orquesta[i++] = new Saxofon();
        orquesta[i++] = new Guzla();
        orquesta[i++] = new Ukelele();
        afinarTodo(orquesta);
    }
}
