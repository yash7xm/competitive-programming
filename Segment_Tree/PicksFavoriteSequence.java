import java.io.*;
import java.util.*;

public class PicksFavoriteSequence {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class SegmentTree {
        int n;
        long[] sum, max;

        public SegmentTree(int[] arr) {
            n = arr.length;
            sum = new long[4 * n];
            max = new long[4 * n];
            build(arr, 1, 0, n - 1);
        }

        void build(int[] a, int v, int tl, int tr) {
            if (tl == tr) {
                sum[v] = max[v] = a[tl];
            } else {
                int tm = (tl + tr) / 2;
                build(a, v * 2, tl, tm);
                build(a, v * 2 + 1, tm + 1, tr);
                sum[v] = sum[v * 2] + sum[v * 2 + 1];
                max[v] = Math.max(max[v * 2], max[v * 2 + 1]);
            }
        }

        void set(int v, int tl, int tr, int pos, int val) {
            if (tl == tr) {
                sum[v] = max[v] = val;
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm) set(v * 2, tl, tm, pos, val);
                else set(v * 2 + 1, tm + 1, tr, pos, val);
                sum[v] = sum[v * 2] + sum[v * 2 + 1];
                max[v] = Math.max(max[v * 2], max[v * 2 + 1]);
            }
        }

        long querySum(int v, int tl, int tr, int l, int r) {
            if (l > r) return 0;
            if (l == tl && r == tr) return sum[v];
            int tm = (tl + tr) / 2;
            return querySum(v * 2, tl, tm, l, Math.min(r, tm)) +
                   querySum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        }

        void modUpdate(int v, int tl, int tr, int l, int r, int x) {
            if (max[v] < x || l > r) return;
            if (tl == tr) {
                sum[v] %= x;
                max[v] = sum[v];
            } else {
                int tm = (tl + tr) / 2;
                modUpdate(v * 2, tl, tm, l, Math.min(r, tm), x);
                modUpdate(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r, x);
                sum[v] = sum[v * 2] + sum[v * 2 + 1];
                max[v] = Math.max(max[v * 2], max[v * 2 + 1]);
            }
        }

        void setValue(int pos, int x) {
            set(1, 0, n - 1, pos, x);
        }

        long getSum(int l, int r) {
            return querySum(1, 0, n - 1, l, r);
        }

        void applyModulo(int l, int r, int x) {
            modUpdate(1, 0, n - 1, l, r, x);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt(), m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        SegmentTree tree = new SegmentTree(a);

        while (m-- > 0) {
            int type = in.nextInt();
            if (type == 1) {
                int l = in.nextInt() - 1, r = in.nextInt() - 1;
                out.println(tree.getSum(l, r));
            } else if (type == 2) {
                int l = in.nextInt() - 1, r = in.nextInt() - 1, x = in.nextInt();
                tree.applyModulo(l, r, x);
            } else if (type == 3) {
                int k = in.nextInt() - 1, x = in.nextInt();
                tree.setValue(k, x);
            }
        }
        out.flush();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens())
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
