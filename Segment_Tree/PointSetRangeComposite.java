import java.util.*;
import java.io.*;

public class PointSetRangeComposite {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Pair {
        long a;
        long b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    static Pair[] tree;
    static int[] arr, brr;
    static int mod = 998244353;

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Pair(arr[start], brr[start]);
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        Pair pair = new Pair(0, 0);
        Pair left = tree[2 * node];
        Pair right = tree[2 * node + 1];
        pair.a = (left.a * right.a) % mod;
        pair.b = (((right.a * left.b) % mod) + right.b) % mod;
        tree[node] = pair;
    }

    static void update(int node, int start, int end, int i, int c, int d) {
        if (start == end) {
            tree[node] = new Pair(c, d);
            return;
        }

        int mid = (start + end) / 2;

        if (i <= mid) {
            update(2 * node, start, mid, i, c, d);
        } else {
            update(2 * node + 1, mid + 1, end, i, c, d);
        }

        Pair pair = new Pair(0, 0);
        Pair left = tree[2 * node];
        Pair right = tree[2 * node + 1];
        pair.a = (left.a * right.a) % mod;
        pair.b = (((right.a * left.b) % mod) + right.b) % mod;
        tree[node] = pair;
    }

    static Pair query(int node, int start, int end, int l, int r) {
        if (start > r || end < l) {
            return new Pair(1, 0);
        }

        if (start >= l && end <= r) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        Pair left = query(2 * node, start, mid, l, r);
        Pair right = query(2 * node + 1, mid + 1, end, l, r);

        Pair pair = new Pair(0, 0);
        pair.a = (left.a * right.a) % mod;
        pair.b = (((right.a * left.b) % mod) + right.b) % mod;

        return pair;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n];
        brr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            brr[i] = in.nextInt();
        }

        tree = new Pair[4 * n];
        build(1, 0, n - 1);

        for (int i = 0; i < q; i++) {
            int type = in.nextInt();

            if (type == 0) {
                int p = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();

                arr[p] = c;
                brr[p] = d;

                update(1, 0, n - 1, p, c, d);
            } else {
                int l = in.nextInt();
                int r = in.nextInt() - 1;
                int x = in.nextInt();

                Pair pair = query(1, 0, n - 1, l, r);

                long res = ((pair.a * x) % mod + pair.b) % mod;

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
