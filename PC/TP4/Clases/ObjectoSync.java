package Clases;

public class ObjectoSync implements Runnable {
    private SynchronizedObjectCounter objectoSync;

    public ObjectoSync(SynchronizedObjectCounter nuObj) {
        objectoSync = nuObj;
    }

    public void run() {
        objectoSync.increment();
        objectoSync.value();
        objectoSync.decrement();
    }
}
