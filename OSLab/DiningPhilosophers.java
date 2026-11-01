import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int n = 5;
        Semaphore[] forks = new Semaphore[n];
        for (int i = 0; i < n; i++) forks[i] = new Semaphore(1);
        Semaphore room = new Semaphore(n - 1);
        for (int i = 0; i < n; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    room.acquire();
                    forks[id].acquire();
                    forks[(id + 1) % n].acquire();
                    System.out.println("Philosopher " + id + " is eating.");
                    Thread.sleep(300);
                    forks[(id + 1) % n].release();
                    forks[id].release();
                    room.release();
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }).start();
        }
    }
}
