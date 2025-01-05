package Two_Pointers;

import java.util.Scanner;

public class NumberOfSegmentsWithBigSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long s = in.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long curr = 0, res = 0;
        for (int i = 0, j = 0; j < n; j++) {
            curr += arr[j];
            while (curr >= s) {
                res += n - j;
                curr -= arr[i];
                i++;
            }
        }

        System.out.println(res);
        in.close();
    }
}
