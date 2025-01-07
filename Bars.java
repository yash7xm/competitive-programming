import java.util.Scanner;

public class Bars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            int[] arr = new int[p];
            for (int i = 0; i < p; i++) {
                arr[i] = in.nextInt();
            }

            String ans = "NO";
            for (int i = 0; i < (1 << p); i++) {
                long sum = 0;
                for (int j = 0; j < 20; j++) {
                    if ((i & (1 << j)) != 0) {
                        sum += arr[j];
                    }
                }

                if (sum == n) {
                    ans = "YES";
                    break;
                }
            }

            System.out.println(ans);
        }
        in.close();
    }
}
