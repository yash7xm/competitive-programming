import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        long res = 0;
        for (int i = 0; i < (1 << N); i++) {
            long currW = 0, currV = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    currW += w[j];
                    currV += v[j];
                }
            }

            if (currW <= W) {
                res = Math.max(res, currV);
            }
        }

        System.out.println(res);
        in.close();
    }
}
