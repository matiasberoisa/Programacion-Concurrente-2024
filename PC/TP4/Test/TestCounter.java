package Test;

import java.util.ArrayList;

import Clases.SynchronizedCounter;
import Clases.SynchronizedObjectCounter;

public class TestCounter {
    public static void main(String[] args) {
        SynchronizedCounter object1 = new SynchronizedCounter();
        SynchronizedObjectCounter object2 = new SynchronizedObjectCounter();
        ArrayList<Thread> hilos = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            hilos.add(new Thread("#1"));
        }
    }
}
