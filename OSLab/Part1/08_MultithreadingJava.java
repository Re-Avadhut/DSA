class PrintTask extends Thread {
    String name;

    PrintTask(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " " + i);
        }
    }
}

class MultithreadingJava {
    public static void main(String[] args) throws InterruptedException {
        PrintTask t1 = new PrintTask("Thread A");
        PrintTask t2 = new PrintTask("Thread B");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Finished");
    }
}
