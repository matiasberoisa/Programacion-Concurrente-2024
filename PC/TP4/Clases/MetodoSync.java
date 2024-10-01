package Clases;

public class MetodoSync implements Runnable {
    private SynchronizedCounter metodoSync;

    public MetodoSync(SynchronizedCounter nuObj) {
        metodoSync = nuObj;
    }

    public void run() {
        metodoSync.increment();
        metodoSync.value();
        metodoSync.decrement();
    }
}
