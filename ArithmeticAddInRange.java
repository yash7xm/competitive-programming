import java.util.*;
import java.io.*;

public class ArithmeticAddInRange {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        long a, d; 

        public Node() {
            this.a = 0;
            this.d = 0;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int size;

        public SegmentTree(int n) {
            this.size = n;
            tree = new Node[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
        }

        private void push(int v, int tl, int tr) {
            if (tree[v].a != 0 || tree[v].d != 0) {
                int tm = (tl + tr) / 2;
                int lenLeft = tm - tl + 1;

                tree[2 * v].a += tree[v].a;
                tree[2 * v].d += tree[v].d;

                tree[2 * v + 1].a += tree[v].a + tree[v].d * lenLeft;
                tree[2 * v + 1].d += tree[v].d;

                tree[v].a = 0;
                tree[v].d = 0;
            }
        }

        public void update(int v, int tl, int tr, int l, int r, long a, long d) {
            if (r < tl || tr < l) return;

            if (l <= tl && tr <= r) {
                long offset = a + d * (tl - l);
                tree[v].a += offset;
                tree[v].d += d;
                return;
            }

            push(v, tl, tr);
            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, r, a, d);
            update(2 * v + 1, tm + 1, tr, l, r, a, d);
        }

        public long query(int v, int tl, int tr, int i) {
            if (tl == tr) {
                return tree[v].a;
            }

            push(v, tl, tr);
            int tm = (tl + tr) / 2;
            if (i <= tm) return query(2 * v, tl, tm, i);
            else return query(2 * v + 1, tm + 1, tr, i);
        }

        public void update(int l, int r, long a, long d) {
            update(1, 1, size, l, r, a, d);
        }

        public long query(int i) {
            return query(1, 1, size, i);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        SegmentTree st = new SegmentTree(n);

        for (int i = 0; i < m; i++) {
            int t = in.nextInt();
            if (t == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                int a = in.nextInt();
                int d = in.nextInt();
                st.update(l, r, a, d);
            } else {
                int idx = in.nextInt();
                out.println(st.query(idx));
            }
        }

        out.flush();
    }

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
