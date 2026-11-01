class NumberPrinter extends Thread {
    private final String label;
    NumberPrinter(String label) { this.label = label; }
    public void run() {
        for (int i = 1; i <= 5; i++) System.out.println(label + ": " + i);
    }
}
public class Multithreading {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new NumberPrinter("Thread 1");
        Thread t2 = new NumberPrinter("Thread 2");
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Both threads finished.");
    }
}
