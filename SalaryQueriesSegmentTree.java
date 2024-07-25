import java.util.*;
import java.io.*;

public class SalaryQueriesSegmentTree {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] arr;
    static ArrayList<Integer>[] tree;

    static void merge(List<Integer> res, List<Integer> lista, List<Integer> listb) {
        int p = 0, q = 0;
        res.clear();
        while (p < lista.size() && q < listb.size()) {
            if (lista.get(p) < listb.get(q)) {
                res.add(lista.get(p));
                p++;
            } else {
                res.add(listb.get(q));
                q++;
            }
        }

        while (q < listb.size()) {
            res.add(listb.get(q));
            q++;
        }

        while (p < lista.size()) {
            res.add(lista.get(p));
            p++;
        }
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node].add(arr[start]);
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    static void update(int node, int start, int end, int k, int x) {
        if (start == end) {
            tree[node].set(0, x);
            return;
        }

        int mid = (start + end) / 2;
        if (k <= mid) {
            update(2 * node, start, mid, k, x);
        } else {
            update(2 * node + 1, mid + 1, end, k, x);
        }

        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    static int upperbound(int x) {
        List<Integer> list = tree[1];

        int lo = 0;
        int hi = list.size() - 1;
        int ans = list.size();

        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if (list.get(mid) > x) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    static int query(int x, int y) {
        int res = 0;
        res = upperbound(y) - upperbound(x - 1);
        return res;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        tree = new ArrayList[4 * n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        build(1, 0, n - 1);

        while (q-- > 0) {
            String line = in.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("?")) {
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);

                int res = 0;
                res = query(a, b);
                out.println(res);
            } else {
                int k = Integer.parseInt(parts[1]);
                int x = Integer.parseInt(parts[2]);

                update(1, 0, n - 1, k - 1, x);
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
