import java.util.*;

public class PagingSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Page size: "); int pageSize = sc.nextInt();
        System.out.print("Logical address: "); int address = sc.nextInt();
        if (pageSize <= 0 || address < 0) { System.out.println("Invalid input."); return; }
        System.out.println("Page number: " + address / pageSize);
        System.out.println("Offset: " + address % pageSize);
    }
}
