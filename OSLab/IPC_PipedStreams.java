import java.io.*;

public class IPC_PipedStreams {
    public static void main(String[] args) throws Exception {
        PipedInputStream input = new PipedInputStream();
        PipedOutputStream output = new PipedOutputStream(input);
        Thread sender = new Thread(() -> {
            try {
                output.write("Message from sender thread".getBytes());
                output.close();
            } catch (IOException e) { e.printStackTrace(); }
        });
        sender.start();
        int data;
        while ((data = input.read()) != -1) System.out.print((char) data);
        System.out.println();
        sender.join(); input.close();
    }
}
