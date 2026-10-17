package STS;

class Karatsuba {
    static int multiply(int x, int y) {
        long result = multiplyLong(x, y);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            throw new ArithmeticException("integer multiplication overflow");
        return (int) result;
    }

    private static long multiplyLong(long x, long y) {
        if (x == 0 || y == 0)
            return 0;
        if (x < 0 || y < 0)
            return x * y;
        // Base case
        if (x < 10 || y < 10)
            return x * y;

        // Calculate the size of the numbers
        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int m = n / 2;
        long p = pow10(m);

        // Split the digit sequences in the middle
        long a = x / p;
        long b = x % p;
        long c = y / p;
        long d = y % p;

        // 3 calls made to numbers approximately half the size
        long ac = multiplyLong(a, c);
        long bd = multiplyLong(b, d);
        long abcd = multiplyLong(a + b, c + d);

        return ac * pow10(2 * m) + (abcd - ac - bd) * p + bd;
    }

    private static long pow10(int exponent) {
        long value = 1;
        for (int i = 0; i < exponent; i++)
            value = Math.multiplyExact(value, 10);
        return value;
    }

    public static void main(String[] args) {
        int x = 1234;
        int y = 5678;
        System.out.println("Product: " + multiply(x, y));
    }
}
