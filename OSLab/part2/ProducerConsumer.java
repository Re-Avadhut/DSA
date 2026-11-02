import java.util.*;
import java.util.concurrent.*;

public class ProducerConsumer {
    static Queue<Integer> q = new LinkedList<>();
    static Semaphore empty = new Semaphore(3);
    static Semaphore full = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    empty.acquire();
                    mutex.acquire();
                    q.add(i);
                    System.out.println("Produced " + i);
                    mutex.release();
                    full.release();
                }
            } catch (Exception e) {
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    full.acquire();
                    mutex.acquire();
                    System.out.println("Consumed " + q.remove());
                    mutex.release();
                    empty.release();
                }
            } catch (Exception e) {
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
