package STS;

import java.util.Scanner;

/**
 * Booth's Multiplication Algorithm (n-bit, two's complement).
 *
 * Memory hook -> "look at the last two bits, then always shift"
 *   Q(last) Q-1
 *     1  0   ->  A = A - M     (one-zero => subtract)
 *     0  1   ->  A = A + M     (zero-one => add)
 *     0  0   ->  nothing
 *     1  1   ->  nothing
 *   Then ALWAYS arithmetic-shift-right (A, Q, Q-1) as ONE register.
 *   Repeat exactly n times. Product = A concatenated with Q (2n bits).
 */
public class BoothAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bits (n): ");
        int n = sc.nextInt();
        System.out.print("Enter multiplicand (M) and multiplier (Q): ");
        int m = sc.nextInt();
        int q = sc.nextInt();

        int limit = 1 << (n - 1);
        if (m < -limit || m > limit - 1 || q < -limit || q > limit - 1) {
            System.out.println("Out of range: " + n + "-bit two's complement holds "
                    + (-limit) + " .. " + (limit - 1));
            sc.close();
            return;
        }

        int[] A = new int[n];        // accumulator starts at 0
        int[] Q = toBits(q, n);      // multiplier
        int[] M = toBits(m, n);      // multiplicand, kept as bits so +/- work on paper
        int qMinus = 0;              // the extra "Q-1" bit starts at 0

        System.out.println();
        System.out.println("M = " + show(M) + " (" + m + "),  Q = " + show(Q) + " (" + q + ")");
        System.out.println();
        header();
        row("init", A, Q, qMinus, "");

        for (int step = 1; step <= n; step++) {
            int test = Q[n - 1] - qMinus;   // 10 -> +1, 01 -> -1, else 0

            String note;
            if (test == 1) {
                A = add(A, negate(M, n), n);
                note = "10 -> A = A - M";
            } else if (test == -1) {
                A = add(A, M, n);
                note = "01 -> A = A + M";
            } else {
                note = (Q[n - 1] + "" + qMinus) + " -> no op";
            }
            row(step + "", A, Q, qMinus, note);

            qMinus = Q[n - 1];              // arithmetic shift right of (A,Q,Q-1)
            Q = shiftIn(Q, A[n - 1]);
            A = shiftIn(A, A[0]);           // A[0] is the sign bit, it replicates
            row(step + "'", A, Q, qMinus, "arithmetic shift right");
        }

        int[] product = new int[2 * n];     // final answer lives in A:Q
        System.arraycopy(A, 0, product, 0, n);
        System.arraycopy(Q, 0, product, n, n);

        System.out.println();
        System.out.println("Product (2n bits) = " + show(product));
        System.out.println(m + " * " + q + " = " + valueOf(product));
        System.out.println("Check             = " + (m * q));
        sc.close();
    }

    private static void header() {
        System.out.println("Step | A     | Q     | Q-1 | Action");
        System.out.println("-----+-------+-------+-----+-----------------");
    }

    private static void row(String step, int[] A, int[] Q, int qMinus, String action) {
        System.out.printf("%-4s | %-5s | %-5s | %-3d | %s%n",
                step, show(A), show(Q), qMinus, action);
    }

    private static String show(int[] b) {
        StringBuilder sb = new StringBuilder();
        for (int bit : b) sb.append(bit);
        return sb.toString();
    }

    private static int[] toBits(int v, int n) {
        int[] b = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            b[i] = v & 1;
            v >>= 1;                     // arithmetic shift: sign bits fill in
        }
        return b;
    }

    private static int[] add(int[] x, int[] y, int n) {
        int[] r = new int[n];
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int s = x[i] + y[i] + carry;
            r[i] = s & 1;
            carry = s >> 1;
        }
        return r;                        // end carry is dropped: that is what makes
    }                                    // two's complement +/- work

    private static int[] negate(int[] x, int n) {
        int[] r = new int[n];
        int carry = 1;                   // two's complement = flip every bit, add 1
        for (int i = n - 1; i >= 0; i--) {
            int s = (1 - x[i]) + carry;
            r[i] = s & 1;
            carry = s >> 1;
        }
        return r;
    }

    private static int[] shiftIn(int[] x, int incoming) {
        int[] r = new int[x.length];
        r[0] = incoming;
        System.arraycopy(x, 0, r, 1, x.length - 1);
        return r;
    }

    private static long valueOf(int[] bits) {
        long v = 0;
        for (int b : bits) v = (v << 1) | b;
        if (bits[0] == 1) v -= (1L << bits.length);   // negative two's complement
        return v;
    }
}
