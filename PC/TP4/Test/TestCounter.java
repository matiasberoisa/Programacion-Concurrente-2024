package Test;

import java.util.ArrayList;

import Clases.*;

public class TestCounter {
    public static void main(String[] args) {
        SynchronizedCounter object1 = new SynchronizedCounter();
        SynchronizedObjectCounter object2 = new SynchronizedObjectCounter();
        ArrayList<Thread> hilosObjectos = new ArrayList<>();
        ArrayList<Thread> hilosMetodos = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            hilosObjectos.add(new Thread(new ObjectoSync(object2)));

        }
        hilosObjectos.forEach(o -> o.start());
        for (int index = 0; index < 5; index++) {
            hilosMetodos.add(new Thread(new MetodoSync(object1)));
        }
        hilosMetodos.forEach(m -> m.start());
    }
}
