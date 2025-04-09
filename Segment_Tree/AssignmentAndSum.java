import java.util.*;
import java.io.*;

public class AssignmentAndSum {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        long lazyValue, sum;
        boolean isLazy;

        public Node(long lazyValue, long sum) {
            this.lazyValue = lazyValue;
            this.sum = sum;
            this.isLazy = false;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int size;

        public SegmentTree(int n) {
            size = n;
            tree = new Node[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node(0, 0);
            }
        }

        private void push(int node, int l, int r) {
            if (tree[node].isLazy) {
                tree[node].sum = (r - l + 1L) * tree[node].lazyValue;

                if (l != r) {
                    tree[2 * node].lazyValue = tree[node].lazyValue;
                    tree[2 * node].isLazy = true;

                    tree[2 * node + 1].lazyValue = tree[node].lazyValue;
                    tree[2 * node + 1].isLazy = true;
                }

                tree[node].isLazy = false;
            }
        }

        public void update(int l, int r, int val) {
            update(1, 0, size - 1, l, r, val);
        }

        private void update(int node, int start, int end, int l, int r, int val) {
            push(node, start, end);
            if (start > r || end < l) return;

            if (l <= start && end <= r) {
                tree[node].lazyValue = val;
                tree[node].isLazy = true;
                push(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);
            tree[node].sum = tree[2 * node].sum + tree[2 * node + 1].sum;
        }

        public long query(int l, int r) {
            return query(1, 0, size - 1, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            push(node, start, end);

            if (start > r || end < l) return 0;

            if (l <= start && end <= r) return tree[node].sum;

            int mid = (start + end) / 2;
            return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
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
