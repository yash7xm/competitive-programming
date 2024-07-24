import java.util.*;
import java.io.*;

public class ListRemovals {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] tree, arr, pos;

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = 1;
            return;
        }

        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    static int query(int node, int start, int end, int k) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (k <= tree[2 * node]) {
            return query(2 * node, start, mid, k);
        } else {
            return query(2 * node + 1, mid + 1, end, k - tree[2 * node]);
        }
    }

    static void delete(int node, int start, int end, int idx) {
        if (start == end) {
            tree[node] = 0;
            return;
        }

        int mid = (start + end) / 2;
        tree[node]--;

        if (idx <= mid) {
            delete(2 * node, start, mid, idx);
        } else {
            delete(2 * node + 1, mid + 1, end, idx);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
        }

        tree = new int[4 * n];
        build(1, 0, n - 1);

        for (int i = 0; i < n; i++) {
            int idx = query(1, 0, n - 1, pos[i]);
            out.print(arr[idx] + " ");
            delete(1, 0, n - 1, idx);
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
