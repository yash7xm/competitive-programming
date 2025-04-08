import java.util.*;
import java.io.*;

public class AdditionAndMinimum {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        long lazy, min;

        public Node(long lazy, long min) {
            this.lazy = lazy;
            this.min = min;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int size;

        public SegmentTree(int n) {
            tree = new Node[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node(0, 0);
            }
            this.size = n;
        }

        private void push(int node, int l, int r) {
            if (tree[node].lazy != 0) {
                tree[node].min += tree[node].lazy;

                if (l != r) {
                    tree[2 * node].lazy += tree[node].lazy;
                    tree[2 * node + 1].lazy += tree[node].lazy;
                }

                tree[node].lazy = 0;
            }
        }

        public void update(int l, int r, int v) {
            update(1, 0, size - 1, l, r, v);
        }

        private void update(int node, int start, int end, int l, int r, int v) {
            push(node, start, end);
            if (start > r || end < l) return;

            if (l <= start && end <= r) {
                tree[node].lazy += v;
                push(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, v);
            update(2 * node + 1, mid + 1, end, l, r, v);
            tree[node].min = Math.min(tree[2 * node].min, tree[2 * node + 1].min);
        }

        public long query(int l, int r) {
            return query(1, 0, size - 1, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (start > r || end < l) return Integer.MAX_VALUE;
            push(node, start, end);

            if (l <= start && end <= r) {
                return tree[node].min;
            }

            int mid = (start + end) / 2;
            return Math.min(query(2 * node, start, mid, l, r),
                     query(2 * node + 1, mid + 1, end, l, r));
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        SegmentTree segTree = new SegmentTree(n);

        while (m-- > 0) {
            int type = in.nextInt();

            if (type == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                int v = in.nextInt();

                segTree.update(l, r - 1, v);
            } else {
                int l = in.nextInt();
                int r = in.nextInt();

                out.println(segTree.query(l, r - 1));
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
