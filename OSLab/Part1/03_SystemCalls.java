import java.io.*;
import java.nio.file.*;

class SystemCalls {
    public static void main(String[] args) throws Exception {
        Path file = Paths.get("demo.txt");

        // File-related OS operations through Java APIs
        Files.writeString(file, "Hello from Java!\n");
        System.out.println("File created/written.");

        System.out.println("File contents:");
        System.out.println(Files.readString(file));

        Files.writeString(file, "Appended text.\n", StandardOpenOption.APPEND);
        System.out.println("Text appended.");

        System.out.println("Current process ID: " + ProcessHandle.current().pid());

        Process p = new ProcessBuilder("ls", "-l").inheritIO().start();
        System.out.println("Command exit code: " + p.waitFor());
    }
}
