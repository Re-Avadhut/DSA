import java.io.*;
import java.nio.file.*;

public class FileOperations {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("os_lab_file.txt");
        Files.writeString(path, "Operating Systems file handling demo.\n");
        System.out.println("File created and written.");
        System.out.println("Contents: " + Files.readString(path));
        Files.writeString(path, "Appended line.\n", StandardOpenOption.APPEND);
        System.out.println("After append:\n" + Files.readString(path));
    }
}
