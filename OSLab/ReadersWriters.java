import java.util.concurrent.Semaphore;

public class ReadersWriters {
    static int readers = 0;
    static final Semaphore mutex = new Semaphore(1);
    static final Semaphore writeLock = new Semaphore(1);

    static void read(int id) {
        try {
            mutex.acquire(); readers++;
            if (readers == 1) writeLock.acquire();
            mutex.release();
            System.out.println("Reader " + id + " is reading.");
            Thread.sleep(300);
            mutex.acquire(); readers--;
            if (readers == 0) writeLock.release();
            mutex.release();
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    static void write(int id) {
        try {
            writeLock.acquire();
            System.out.println("Writer " + id + " is writing.");
            Thread.sleep(300);
            writeLock.release();
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    public static void main(String[] args) {
        new Thread(() -> read(1)).start();
        new Thread(() -> read(2)).start();
        new Thread(() -> write(1)).start();
    }
}
