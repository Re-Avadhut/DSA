package STS;

import java.util.*;

//Leaders in an array
//Leader : all right side elements are smaller 
//ts: O(n) sc: O(n)

public class LeadersArray {
    static void leaders(int arr[], int n) {
        int max = arr[n - 1];
        ArrayList<Integer> leaders = new java.util.ArrayList<>();
        leaders.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                leaders.add(max);
            }
        }
        Collections.reverse(leaders);
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 16, 17, 4, 3, 5, 2 };
        int n = arr.length;
        leaders(arr, n);
    }
}
