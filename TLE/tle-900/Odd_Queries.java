import java.util.Scanner;

public class Odd_Queries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int q = in.nextInt();

            int[] arr = new int[n];
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                p[i] = arr[i];
                if (i != 0) {
                    p[i] += p[i - 1];
                }
            }

            int[][] quer = new int[q][3];
            for (int i = 0; i < q; i++) {
                quer[i][0] = in.nextInt();
                quer[i][1] = in.nextInt();
                quer[i][2] = in.nextInt();
            }

            int sum = p[n - 1];

            for (int i = 0; i < q; i++) {
                int l = quer[i][0] - 1;
                int r = quer[i][1] - 1;
                int k = quer[i][2];

                int psum = p[r] - (l > 0 ? p[l - 1] : 0);
                int tempSum = sum - psum + (r - l + 1) * k;
                if (tempSum % 2 == 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
        in.close();
    }
}
