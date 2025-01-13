package Bit_Manipulation;

import java.util.Scanner;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            long grp1 = 0, grp2 = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    grp1 += arr[j];
                } else {
                    grp2 += arr[j];
                }
            }

            res = Math.min(res, Math.abs(grp1 - grp2));
        }

        System.out.println(res);
        in.close();
    }
}
