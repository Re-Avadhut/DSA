public class Process_Thread_Concepts {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Current process ID: " + ProcessHandle.current().pid());
        Thread worker = new Thread(() -> System.out.println("Running inside a Java thread."));
        worker.start();
        worker.join();
        System.out.println("Java cannot directly reproduce Unix fork()/exec()/wait() semantics portably.");
    }
}
