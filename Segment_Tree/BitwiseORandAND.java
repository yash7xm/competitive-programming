import java.util.*;
import java.io.*;

public class BitwiseORandAND {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        long lazy;
        int[] a;

        public Node() {
            this.a = new int[32];
            this.lazy = 0;
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
            if (tree[v].lazy != 0) {
                for (int i = 0; i < 32; i++) {
                    if (((1 << i) & tree[v].lazy) != 0) {
                        tree[v].a[i] = (tr - tl + 1);
                    }
                }

                if (tl != tr) {
                    tree[v * 2].lazy |= tree[v].lazy;
                    tree[v * 2 + 1].lazy |= tree[v].lazy;
                }

                tree[v].lazy = 0;
            }
        }

        private Node merge(Node left, Node right) {
            Node n = new Node();
            for (int i = 0; i < 32; i++) {
                n.a[i] = left.a[i] + right.a[i];
            }
            return n;
        }

        public void update(int v, int tl, int tr, int l, int r, int val) {
            push(v, tl, tr);
            if (r < tl || tr < l) return;

            if (l <= tl && tr <= r) {
                tree[v].lazy |= val;
                push(v, tl, tr);
                return;
            }

            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, r, val);
            update(2 * v + 1, tm + 1, tr, l, r, val);
            tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
        }

        public Node query(int v, int tl, int tr, int l, int r) {
            push(v, tl, tr);
            if (r < tl || tr < l) return new Node();

            if (l <= tl && tr <= r) {
                return tree[v];
            }

            int tm = (tl + tr) / 2;

            Node left = query(2 * v, tl, tm, l, r);
            Node right = query(2 * v + 1, tm + 1, tr, l, r);

            return merge(left, right);
        }

        public void update(int l, int r, int v) {
            update(1, 0, size - 1, l, r - 1, v);
        }

        public int query(int l, int r) {
            Node result = query(1, 0, size - 1, l, r - 1);
            int res = 0;
            int rangeSize = r - l;
            for (int i = 0; i < 32; i++) {
                if (result.a[i] == rangeSize) {
                    res |= (1 << i);
                }
            }
            return res;
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
                int v = in.nextInt();
                st.update(l, r, v);
            } else {
                int l = in.nextInt();
                int r = in.nextInt();
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
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
