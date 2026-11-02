import java.util.concurrent.*;

class ReadersWriters {
    static int readers = 0;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore write = new Semaphore(1);

    static void read(int n) throws Exception {
        mutex.acquire();
        readers++;
        if (readers == 1) {
            write.acquire();
        }
        mutex.release();
        System.out.println("Reader " + n + " reading");
        Thread.sleep(100);
        mutex.acquire();
        readers--;
        if (readers == 0) {
            write.release();
        }
        mutex.release();
    }

    static void write(int n) throws Exception {
        write.acquire();
        System.out.println("Writer " + n + " writing");
        Thread.sleep(100);
        write.release();
    }

    public static void main(String[] a) throws Exception {
        Thread r1 = new Thread(() -> {
            try {
                read(1);
            } catch (Exception e) {
            }
        });
        Thread r2 = new Thread(() -> {
            try {
                read(2);
            } catch (Exception e) {
            }
        });
        Thread w = new Thread(() -> {
            try {
                write(1);
            } catch (Exception e) {
            }
        });

        r1.start();
        r2.start();
        w.start();
        r1.join();
        r2.join();
        w.join();
    }
}
