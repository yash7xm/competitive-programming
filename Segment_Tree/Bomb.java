import java.util.*;
import java.io.*;

public class Bomb {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Pair {
        int max;
        int idx;

        Pair(int max, int idx) {
            this.max = max;
            this.idx = idx;
        }
    }

    static int[] arr, brr;
    static Pair[] tree;

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Pair(arr[start], start);
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        if (tree[2 * node].max > tree[2 * node + 1].max) {
            tree[node] = new Pair(tree[2 * node].max, tree[2 * node].idx);
        } else {
            tree[node] = new Pair(tree[2 * node + 1].max, tree[2 * node + 1].idx);
        }
    }

    static void update(int node, int start, int end, int i) {
        if (start == end) {
            tree[node] = new Pair(Math.max(0, arr[i] - brr[i]), i);
            arr[i] = Math.max(0, arr[i] - brr[i]);
            return;
        }

        int mid = (start + end) / 2;

        if (i <= mid) {
            update(2 * node, start, mid, i);
        } else {
            update(2 * node + 1, mid + 1, end, i);
        }

        if (tree[2 * node].max > tree[2 * node + 1].max) {
            tree[node] = new Pair(tree[2 * node].max, tree[2 * node].idx);
        } else {
            tree[node] = new Pair(tree[2 * node + 1].max, tree[2 * node + 1].idx);
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            arr = new int[n];
            brr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                brr[i] = in.nextInt();
            }

            tree = new Pair[4 * n];

            build(1, 0, n - 1);

            long sum = 0;
            while (k-- > 0) {
                sum += tree[1].max;
                update(1, 0, n - 1, tree[1].idx);
            }

            out.println(sum);
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
