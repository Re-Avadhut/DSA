import java.io.*;
import java.nio.charset.StandardCharsets;

class IPCUsingPipes {
    public static void main(String[] args) throws Exception {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream(in);
        Thread sender = new Thread(() -> {
            try {
                out.write("Hello through pipe!".getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.err.println("Pipe write failed: " + e.getMessage());
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    System.err.println("Pipe close failed: " + e.getMessage());
                }
            }
        });

        sender.start();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println();
        sender.join();
        in.close();
    }
}
