package Greedy;

import java.util.Scanner;

public class Crafting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] brr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                brr[i] = in.nextInt();
            }

            int[] left = new int[n];
            int[] right = new int[n];

            for (int i = 0; i < n; i++) {
                left[i] = arr[i] - brr[i];
                if (i != 0) {
                    left[i] = Math.min(left[i], left[i - 1]);
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                right[i] = arr[i] - brr[i];
                if (i != n - 1) {
                    right[i] = Math.min(right[i], right[i + 1]);
                }
            }

            String res = "YES";
            for (int i = 0; i < n; i++) {
                int l = i == 0 ? Integer.MAX_VALUE : left[i - 1];
                int r = i == n - 1 ? Integer.MAX_VALUE : right[i + 1];

                int min = Math.min(l, r);

                if (brr[i] - arr[i] > min) {
                    res = "NO";
                    break;
                }
            }

            System.out.println(res);
        }
        in.close();
    }
}
