import java.util.*;

public class RangeUpdatePointQuery {
    static class FenwickTree {
        long[] bit;
        int n;

        FenwickTree(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, long delta) {
            while (idx <= n) {
                bit[idx] += delta;
                idx += idx & -idx;
            }
        }

        long prefixSum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }

        FenwickTree ft = new FenwickTree(n + 2);
        for (int i = 1; i <= n; i++) {
            ft.add(i, arr[i] - arr[i - 1]);
        }

        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                long u = sc.nextLong();

                ft.add(a, u);
                ft.add(b + 1, -u);
            } else if (type == 2) {
                int k = sc.nextInt();
                System.out.println(ft.prefixSum(k));
            }
        }
    }
}
