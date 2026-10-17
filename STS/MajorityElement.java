package STS;

//Majority Element

//freq of the element is greater than n/2
//tc: O(n) sc: O(1)

class Main {

    static int majorityElement(int[] arr) {
        int cd = 0;
        int count = 0;
        for (int x : arr) {
            if (count == 0) {
                cd = x;
                count = 1;
            } else if (cd == x)
                count++;
            else
                count--;
        }
        count = 0;
        for (int x : arr) {
            if (x == cd)
                count++;
        }
        if (count > arr.length / 2)
            return cd;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr));
    }
}