package STS;

class Karatsuba {
    static int multiply(int x, int y) {
        // Base case
        if (x < 10 || y < 10)
            return x * y;

        // Calculate the size of the numbers
        int n = Math.max(Integer.toString(x).length(), Integer.toString(y).length());
        int m = n / 2;
        int p = (int) Math.pow(10, m);

        // Split the digit sequences in the middle
        int a = x / p;
        int b = x % p;
        int c = y / p;
        int d = y % p;

        // 3 calls made to numbers approximately half the size
        int ac = multiply(a, c);
        int bd = multiply(b, d);
        int abcd = multiply(a + b, c + d);

        return ac * (int) Math.pow(10, 2 * m) + (abcd - ac - bd) * p + bd;
    }

    public static void main(String[] args) {
        int x = 1234;
        int y = 5678;
        System.out.println("Product: " + multiply(x, y));
    }
}
