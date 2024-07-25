import java.util.*;
import java.io.*;

public class PizzeriaQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] arr, up, down;

    static void build(int node, int start, int end, int x, int[] tree) {
        if (start == end) {
            tree[node] = arr[start] + (start) * x;
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid, x, tree);
        build(2 * node + 1, mid + 1, end, x, tree);

        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    static int query(int node, int start, int end, int l, int r, int[] tree) {
        if (start >= l && end <= r) {
            return tree[node];
        }

        if (start > r || end < l) {
            return Integer.MAX_VALUE;
        }

        int mid = (start + end) / 2;
        return Math.min(query(2 * node, start, mid, l, r, tree), query(2 * node + 1, mid + 1, end, l, r, tree));
    }

    static void update(int node, int start, int end, int i, int val, int x, int[] tree) {
        if (start == end) {
            tree[node] = val + x * (start);
            return;
        }

        int mid = (start + end) / 2;

        if (i <= mid) {
            update(2 * node, start, mid, i, val, x, tree);
        } else {
            update(2 * node + 1, mid + 1, end, i, val, x, tree);
        }

        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        up = new int[4 * n];
        down = new int[4 * n];

        build(1, 1, n, 1, up);
        build(1, 1, n, -1, down);

        for (int i = 0; i < q; i++) {
            int type = in.nextInt();

            if (type == 1) {
                int k = in.nextInt();
                int x = in.nextInt();

                arr[k] = x;
                update(1, 1, n, k, x, 1, up);
                update(1, 1, n, k, x, -1, down);
            } else {
                int k = in.nextInt();

                int mindown = query(1, 1, n, 1, k, down);
                int minup = query(1, 1, n, k, n, up);

                int res = Math.min(mindown + k, minup - k);

                out.println(res);
            }
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
