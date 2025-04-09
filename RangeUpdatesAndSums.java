import java.util.*;
import java.io.*;

public class RangeUpdatesAndSums {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        long lazyAdd, lazySet, sum;

        public Node(long lazyAdd, long lazySet, long sum) {
            this.lazyAdd = lazyAdd;
            this.lazySet = lazySet;
            this.sum = sum;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int[] A;
        int size;

        public SegmentTree(int[] a) {
            this.size = a.length;
            tree = new Node[4 * size];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node(0L, 0L, 0L);
            }
            this.A = a;
            build(1, 0, size - 1);
        }

        private Node merge(Node left, Node right) {
            return new Node(0L , 0L, left.sum + right.sum);
        }

        private void push(int v, int tl, int tr) {
            if (tree[v].lazySet != 0) {
                tree[v].sum = tree[v].lazySet * (tr - tl + 1);
                if (tl != tr) {
                    tree[v*2].lazySet = tree[v].lazySet;
                    tree[v*2+1].lazySet = tree[v].lazySet;
                    tree[v*2].lazyAdd = 0;
                    tree[v*2+1].lazyAdd = 0;
                }
                tree[v].lazySet = 0;
            }

            if (tree[v].lazyAdd != 0) {
                tree[v].sum += tree[v].lazyAdd * (tr - tl + 1);
                if (tl != tr) {
                    tree[v*2].lazyAdd += tree[v].lazyAdd;
                    tree[v*2+1].lazyAdd += tree[v].lazyAdd;
                }
                tree[v].lazyAdd = 0;
            }
        }   


        public void build(int v, int tl, int tr) {
            if (tl == tr) {
                tree[v].sum += A[tl];
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
                if (type == 1) {
                    tree[v].lazyAdd += val;
                } else {
                    tree[v].lazySet = val;
                    tree[v].lazyAdd = 0;
                }
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
            if (l <= tl && tr <= r) return tree[v].sum;
            int tm = (tl + tr) / 2;
            long left = query(2 * v, tl, tm, l, r);
            long right = query(2 * v + 1, tm + 1, tr, l, r);
            return (left + right);
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
        for (int i = 0; i < n; i++) A[i] = in.nextInt();

        SegmentTree st = new SegmentTree(A);

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
