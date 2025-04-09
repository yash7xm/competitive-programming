import java.util.*;
import java.io.*;

public class PolynomialQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        long a, d, sum; 

        public Node() {
            this.a = 0;
            this.d = 0;
            this.sum = 0;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int[] a;
        int size;

        public SegmentTree(int[] a) {
            this.size = a.length;
            tree = new Node[4 * size];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
            this.a = Arrays.copyOf(a, size);
            build(1,1,size);
        }

        private void push(int v, int tl, int tr) {
            if (tree[v].a != 0 || tree[v].d != 0) {
                int tm = (tl + tr) / 2;
                int lenLeft = tm - tl + 1;

                int n = tr-tl+1;
                tree[v].sum += n*(2*tree[v].a + (n-1)*tree[v].d)/2;

                if(tl != tr) {
                    tree[2 * v].a += tree[v].a;
                    tree[2 * v].d += tree[v].d;

                    tree[2 * v + 1].a += tree[v].a + tree[v].d * lenLeft;
                    tree[2 * v + 1].d += tree[v].d;
                }

                tree[v].a = 0;
                tree[v].d = 0;
            }
        }

        public void build(int v, int tl, int tr) {
            if(tl == tr) {
                tree[v].sum = a[tl-1];
            } else {
                int tm = (tl + tr) / 2;
                build(v*2, tl, tm);
                build(v*2+1, tm+1, tr);
                tree[v].sum = tree[v*2].sum + tree[v*2+1].sum;
            }
        }

        public void update(int v, int tl, int tr, int l, int r, long a, long d) {
            push(v, tl, tr);
            if (r < tl || tr < l) return;
            if (l <= tl && tr <= r) {
                long offset = a + d * (tl - l);
                tree[v].a += offset;
                tree[v].d += d;
                push(v, tl, tr);
                return;
            }

            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, r, a, d);
            update(2 * v + 1, tm + 1, tr, l, r, a, d);
            tree[v].sum = tree[v*2].sum + tree[v*2+1].sum;
        }

        public long query(int v, int tl, int tr, int l, int r) {
            push(v, tl, tr);
            if (r < tl || tr < l) return 0;
            if (l <= tl && tr <= r) {
                return tree[v].sum;
            }

            int tm = (tl + tr) / 2;
            return query(2 * v, tl, tm, l, r) + query(2 * v + 1, tm + 1, tr, l, r);
        }

        public void update(int l, int r, long a, long d) {
            update(1, 1, size, l, r, a, d);
        }

        public long query(int l, int r) {
            return query(1, 1, size, l, r);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        SegmentTree st = new SegmentTree(arr);

        for (int i = 0; i < m; i++) {
            int t = in.nextInt();
            if (t == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                st.update(l, r, 1, 1);
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
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
