import java.io.*;
import java.util.*;

public class SUMAndREPLACE {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static final int MAX_A = 1_000_001;
    static int[] D = new int[MAX_A];

    static void preprocess() {
        for (int i = 1; i < MAX_A; i++) {
            for (int j = i; j < MAX_A; j += i) {
                D[j]++;
            }
        }
    }

    static class SegmentTree {
        int[] arr;
        long[] sumTree;
        int[] maxTree;
        int size;

        SegmentTree(int[] arr) {
            this.size = arr.length;
            this.arr = new int[size];
            this.sumTree = new long[4 * size];
            this.maxTree = new int[4 * size];
            System.arraycopy(arr, 0, this.arr, 0, size);
            build(1, 0, size - 1);
        }

        void build(int v, int tl, int tr) {
            if (tl == tr) {
                sumTree[v] = arr[tl];
                maxTree[v] = arr[tl];
            } else {
                int tm = (tl + tr) / 2;
                build(2 * v, tl, tm);
                build(2 * v + 1, tm + 1, tr);
                pull(v);
            }
        }

        void pull(int v) {
            sumTree[v] = sumTree[2 * v] + sumTree[2 * v + 1];
            maxTree[v] = Math.max(maxTree[2 * v], maxTree[2 * v + 1]);
        }

        void update(int v, int tl, int tr, int l, int r) {
            if (tl > r || tr < l || maxTree[v] <= 2) return;
            if (tl == tr) {
                arr[tl] = D[arr[tl]];
                sumTree[v] = arr[tl];
                maxTree[v] = arr[tl];
                return;
            }

            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, r);
            update(2 * v + 1, tm + 1, tr, l, r);
            pull(v);
        }

        long querySum(int v, int tl, int tr, int l, int r) {
            if (tl > r || tr < l) return 0;
            if (l <= tl && tr <= r) return sumTree[v];
            int tm = (tl + tr) / 2;
            return querySum(2 * v, tl, tm, l, r) + querySum(2 * v + 1, tm + 1, tr, l, r);
        }

        void update(int l, int r) {
            update(1, 0, size - 1, l, r);
        }

        long querySum(int l, int r) {
            return querySum(1, 0, size - 1, l, r);
        }
    }

    public static void main(String[] args) {
        preprocess();

        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        SegmentTree st = new SegmentTree(a);

        while (m-- > 0) {
            int t = in.nextInt();
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;

            if (t == 1) {
                st.update(l, r);
            } else {
                out.println(st.querySum(l, r));
            }
        }

        out.flush();
    }

    // Fast IO
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
