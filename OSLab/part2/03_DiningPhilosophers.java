import java.util.concurrent.*;

class DiningPhilosophers {
    public static void main(String[] a) throws Exception {
        int n = 5;
        Semaphore[] fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }

        Semaphore room = new Semaphore(n - 1);
        Thread[] t = new Thread[n];
        for (int i = 0; i < n; i++) {
            final int p = i;
            t[i] = new Thread(() -> {
                try {
                    room.acquire();
                    fork[p].acquire();
                    fork[(p + 1) % n].acquire();
                    System.out.println("Philosopher " + p + " eating");
                    Thread.sleep(100);
                    fork[p].release();
                    fork[(p + 1) % n].release();
                    room.release();
                } catch (Exception e) {
                }
            });
            t[i].start();
        }

        for (Thread x : t) {
            x.join();
        }
    }
}
