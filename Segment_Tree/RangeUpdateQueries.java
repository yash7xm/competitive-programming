import java.util.*;
import java.io.*;

public class RangeUpdateQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class SegmentTree {
        long[] tree;

        SegmentTree(int[] arr) {
            int n = arr.length;
            this.tree = new long[4 * n];
            this.build(1, 0, n - 1, arr);
        }

        void build(int node, int start, int end, int[] arr) {
            if (start == end) {
                this.tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            this.build(2 * node, start, mid, arr);
            this.build(2 * node + 1, mid + 1, end, arr);
        }

        void query(int node, int start, int end, int i, long[] res) {
            if (start == end) {
                res[0] += this.tree[node];
                return;
            }

            int mid = (start + end) / 2;
            res[0] += this.tree[node];

            if (i <= mid) {
                this.query(2 * node, start, mid, i, res);
            } else {
                this.query(2 * node + 1, mid + 1, end, i, res);
            }
        }

        void update(int node, int start, int end, int l, int r, int x) {
            if (start >= l && end <= r) {
                this.tree[node] += x;
                return;
            }

            if (start > r || end < l) {
                return;
            }

            int mid = (start + end) / 2;
            this.update(2 * node, start, mid, l, r, x);
            this.update(2 * node + 1, mid + 1, end, l, r, x);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[][] quer = new int[q][4];
        for (int i = 0; i < q; i++) {
            int type = in.nextInt();
            if (type == 1) {
                quer[i][0] = type;
                quer[i][1] = in.nextInt();
                quer[i][2] = in.nextInt();
                quer[i][3] = in.nextInt();
            } else {
                quer[i][0] = type;
                quer[i][1] = in.nextInt();
            }
        }

        SegmentTree sg = new SegmentTree(arr);

        for (int i = 0; i < q; i++) {
            int type = quer[i][0];
            if (type == 1) {
                int l = quer[i][1] - 1;
                int r = quer[i][2] - 1;
                int u = quer[i][3];
                sg.update(1, 0, n - 1, l, r, u);
            } else {
                int l = quer[i][1] - 1;
                long[] res = new long[1];
                sg.query(1, 0, n - 1, l, res);
                out.println(res[0]);
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
