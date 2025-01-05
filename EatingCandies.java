import java.util.Scanner;

public class EatingCandies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long sum1 = arr[0], sum2 = arr[n - 1];
            int i = 0, j = n - 1;
            int res = 0;
            while (i < j) {
                if (sum1 == sum2) {
                    res = (i + 1) + (n - j);
                    i++;
                    j--;
                    sum1 += arr[i];
                    sum2 += arr[j];
                } else if (sum1 > sum2) {
                    j--;
                    sum2 += arr[j];
                } else {
                    i++;
                    sum1 += arr[i];
                }
            }

            System.out.println(res);
        }
        in.close();
    }
}
