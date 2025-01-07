package Bit_Manipulation;

import java.util.Scanner;

public class PetrAndACombinationLock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < (1 << n); i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    sum -= arr[j];
                } else {
                    sum += arr[j];
                }
            }

            if (sum % 360 == 0) {
                System.out.println("YES");
                in.close();
                return;
            }
        }

        System.out.println("NO");
        in.close();
    }
}
