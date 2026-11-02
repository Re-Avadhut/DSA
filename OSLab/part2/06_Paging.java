import java.util.*;

class Paging {
  public static void main(String[] a) {
    Scanner s = new Scanner(System.in);
    int total = s.nextInt(), size = s.nextInt();

    int frames = total / size;
    int os = s.nextInt();
    int used = (os + size - 1) / size;
    int free = frames - used;

    int[] job = new int[20], start = new int[20], end = new int[20];
    int n = 0;

    if (used > 0) {
      job[n] = 1;
      start[n] = 0;
      end[n++] = used - 1;
    }
    char ch;
    do {
      int bytes = s.nextInt();
      int need = (bytes + size - 1) / size;
      if (need <= free) {
        job[n] = n + 1;
        start[n] = end[n - 1] + 1;
        end[n++] = start[n - 1] + need - 1;
        free -= need;
      } else
        System.out.println("Memory is not sufficient.");
      ch = s.next().charAt(0);
    } while (ch != 'n' && ch != 'N');
    System.out.println("Job\tStart\tEnd");
    for (int i = 0; i < n; i++)
      System.out.println(job[i] + "\t" + start[i] + "\t" + end[i]);
    System.out.println("Free frames = " + free);
  }
}
