import java.util.*;
import java.io.*;

public class SubarraySumQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Node {
        long sum;
        long maxsubsum;
        long prefix;
        long suffix;

        Node(long sum, long maxsubsum, long prefix, long suffix) {
            this.sum = sum;
            this.maxsubsum = maxsubsum;
            this.prefix = prefix;
            this.suffix = suffix;
        }
    }

    static int[] arr;
    static Node[] tree;

    static Node merge(Node left, Node right) {
        Node node = new Node(0, 0, 0, 0);

        node.sum = left.sum + right.sum;
        node.prefix = Math.max(left.prefix, left.sum + right.prefix);
        node.suffix = Math.max(right.suffix, right.sum + left.suffix);
        node.maxsubsum = Math.max(node.sum,
                Math.max(left.maxsubsum, Math.max(right.maxsubsum, left.suffix + right.prefix)));

        return node;
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start], arr[start], arr[start], arr[start]);
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    static void update(int node, int start, int end, int i, int x) {
        if (start == end) {
            tree[node] = new Node(arr[start], arr[start], arr[start], arr[start]);
            return;
        }

        int mid = (start + end) / 2;

        if (i <= mid) {
            update(2 * node, start, mid, i, x);
        } else {
            update(2 * node + 1, mid + 1, end, i, x);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        tree = new Node[4 * n];
        build(1, 0, n - 1);

        for (int i = 0; i < q; i++) {
            int k = in.nextInt() - 1;
            int x = in.nextInt();

            arr[k] = x;
            update(1, 0, n - 1, k, x);
            long res = tree[1].maxsubsum;
            if (res < 0)
                res = 0;
            out.println(res);
        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
