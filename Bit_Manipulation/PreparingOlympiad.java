package Bit_Manipulation;

import java.util.Scanner;

public class PreparingOlympiad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int x = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int res = 0;

        for (int i = 0; i < (1 << n); i++) {
            long sum = 0;
            int k = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 15; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    min = Math.min(arr[j], min);
                    max = Math.max(arr[j], max);
                    k++;
                }
            }

            if (sum >= l && sum <= r && max - min >= x && k >= 2) {
                res++;
            }
        }

        System.out.println(res);
        in.close();
    }
}
