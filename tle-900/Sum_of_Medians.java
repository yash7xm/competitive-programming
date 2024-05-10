import java.util.Scanner;

public class Sum_of_Medians {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n * k];

            for (int i = 0; i < n * k; i++) {
                arr[i] = in.nextInt();
            }

            long sum = 0;
            int d = (n / 2) + 1;
            int idx = n * k - d;
            while (k-- > 0) {
                sum += arr[idx];
                idx -= d;
            }
            System.out.println(sum);
        }
        in.close();
    }
}
