package parcialesRecuperatorios.pelicula;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pelicula {
    private ReentrantLock lockEspañol, lockIngles;
    private Condition traductores, sociosEspañol, sociosIngles;
    private int episodiosFilmados, episodiosTraducidos;
    private int cantTraductores, cantSociosEspañol, cantSociosIngles;

    public Pelicula() {
        lockEspañol = new ReentrantLock();
        lockIngles = new ReentrantLock();
        traductores = lockIngles.newCondition();
        sociosIngles = lockIngles.newCondition();
        sociosEspañol = lockEspañol.newCondition();
        cantTraductores = 0;
        cantSociosEspañol = 0;
        cantSociosIngles = 0;
    }

    public void filmarCapitulo() {
        lockEspañol.lock();
        episodiosFilmados++;
        lockEspañol.unlock();
    }

    public void publicarCapitulo() {
        traductores.signalAll();
        sociosEspañol.signalAll();
    }

    public void traducirCapitulo() {
        lockIngles.lock();
        try {
            if (episodiosTraducidos >= episodiosFilmados && cantTraductores < 1) {
                cantTraductores++;
                episodiosTraducidos++;
            } else {
                while (episodiosTraducidos >= episodiosFilmados || cantTraductores >= 1) {
                    traductores.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockIngles.unlock();
        }
    }

    public void publicarTraduccion() {
        lockIngles.lock();
        cantTraductores--;
        sociosIngles.signalAll();
        lockIngles.unlock();
    }

    public void mirarCapituloEspañol(int episodiosVistos) {
        lockEspañol.lock();
        try {
            if (episodiosVistos >= episodiosFilmados && cantSociosEspañol < 5) {
                cantSociosEspañol++;
            } else {
                while (episodiosVistos >= episodiosFilmados || cantSociosEspañol >= 5) {
                    sociosEspañol.await();
                }
            }
        } catch (Exception e) {
        } finally {
            lockEspañol.unlock();
        }
    }

    public void mirarCapituloIngles(int episodiosVistos) {
        lockIngles.lock();
        try {
            if (episodiosVistos >= episodiosFilmados && cantSociosIngles < 5) {
                cantSociosIngles++;
            } else {
                while (episodiosVistos >= episodiosFilmados || cantSociosIngles >= 5) {
                    sociosIngles.await();
                }
            }
        } catch (Exception e) {
        } finally {
            lockIngles.unlock();
        }
    }

    public void terminarCapitulo() {
        lockEspañol.lock();
        cantSociosEspañol--;
        if (cantSociosEspañol == 0) {
            sociosEspañol.signalAll();
        }
        lockEspañol.unlock();
    }

    public void habilitarTraductor() {
        lockIngles.lock();
        cantSociosIngles--;
        if (cantSociosIngles == 0) {
            traductores.signalAll();
        }
        lockIngles.unlock();
    }
}
