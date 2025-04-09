import java.util.*;
import java.io.*;

public class TwoSequenceQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static final int MOD = 998244353;

    static class Node {
        long lazyA, lazyB, sumA, sumB, sumAB;

        public Node(long lazyA, long lazyB, long sumAB, long sumA, long sumB) {
            this.lazyA = lazyA;
            this.lazyB = lazyB;
            this.sumAB = sumAB;
            this.sumA = sumA;
            this.sumB = sumB;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int[] A, B;
        int size;

        public SegmentTree(int[] a, int[] b) {
            this.size = a.length;
            tree = new Node[4 * size];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node(0L, 0L, 0L, 0L, 0L);
            }
            this.A = a;
            this.B = b;
            build(1, 0, size - 1);
        }

        private Node merge(Node left, Node right) {
            return new Node(0, 0,
                (left.sumAB + right.sumAB) % MOD,
                (left.sumA + right.sumA) % MOD,
                (left.sumB + right.sumB) % MOD
            );
        }

        private void push(int v, int tl, int tr) {
            if (tree[v].lazyA != 0 || tree[v].lazyB != 0) {
                int len = tr - tl + 1;

                tree[v].sumAB = (tree[v].sumAB +
                        tree[v].lazyA * tree[v].sumB % MOD +
                        tree[v].lazyB * tree[v].sumA % MOD +
                        tree[v].lazyA * tree[v].lazyB % MOD * len % MOD) % MOD;

                tree[v].sumA = (tree[v].sumA + tree[v].lazyA * len % MOD) % MOD;
                tree[v].sumB = (tree[v].sumB + tree[v].lazyB * len % MOD) % MOD;

                if (tl != tr) {
                    tree[2 * v].lazyA = (tree[2 * v].lazyA + tree[v].lazyA) % MOD;
                    tree[2 * v + 1].lazyA = (tree[2 * v + 1].lazyA + tree[v].lazyA) % MOD;
                    tree[2 * v].lazyB = (tree[2 * v].lazyB + tree[v].lazyB) % MOD;
                    tree[2 * v + 1].lazyB = (tree[2 * v + 1].lazyB + tree[v].lazyB) % MOD;
                }

                tree[v].lazyA = 0;
                tree[v].lazyB = 0;
            }
        }

        public void build(int v, int tl, int tr) {
            if (tl == tr) {
                tree[v].sumA = A[tl];
                tree[v].sumB = B[tl];
                tree[v].sumAB = (1L * A[tl] * B[tl]) % MOD;
            } else {
                int tm = (tl + tr) / 2;
                build(2 * v, tl, tm);
                build(2 * v + 1, tm + 1, tr);
                tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
            }
        }

        public void update(int v, int tl, int tr, int l, int r, long val, int type) {
            push(v, tl, tr);
            if (tr < l || tl > r) return;
            if (l <= tl && tr <= r) {
                if (type == 1)
                    tree[v].lazyA = (tree[v].lazyA + val) % MOD;
                else
                    tree[v].lazyB = (tree[v].lazyB + val) % MOD;
                push(v, tl, tr);
                return;
            }
            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, r, val, type);
            update(2 * v + 1, tm + 1, tr, l, r, val, type);
            tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
        }

        public long query(int v, int tl, int tr, int l, int r) {
            push(v, tl, tr);
            if (tr < l || tl > r) return 0;
            if (l <= tl && tr <= r) return tree[v].sumAB;
            int tm = (tl + tr) / 2;
            long left = query(2 * v, tl, tm, l, r);
            long right = query(2 * v + 1, tm + 1, tr, l, r);
            return (left + right) % MOD;
        }

        public void update(int l, int r, int x, int type) {
            update(1, 0, size - 1, l - 1, r - 1, x, type);
        }

        public long query(int l, int r) {
            return query(1, 0, size - 1, l - 1, r - 1);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) A[i] = in.nextInt();
        for (int i = 0; i < n; i++) B[i] = in.nextInt();

        SegmentTree st = new SegmentTree(A, B);

        for (int i = 0; i < q; i++) {
            int t = in.nextInt();
            if (t == 1) {
                int l = in.nextInt(), r = in.nextInt(), x = in.nextInt();
                st.update(l, r, x, 1);
            } else if (t == 2) {
                int l = in.nextInt(), r = in.nextInt(), x = in.nextInt();
                st.update(l, r, x, 2);
            } else {
                int l = in.nextInt(), r = in.nextInt();
                out.println(st.query(l, r));
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
