import java.util.*;
import java.io.*;

public class SalaryQueriesCompressedSeg {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Queries {
        int type;
        int a;
        int b;

        Queries(int type, int a, int b) {
            this.type = type;
            this.a = a;
            this.b = b;
        }
    }

    static int[] arr, tree;
    static List<Integer> allVals;
    static List<Queries> quers;
    static Map<Integer, Integer> map;

    static void compressIndexes() {
        Collections.sort(allVals);
        int idx = 0;

        for (int val : allVals) {
            if (!map.containsKey(val)) {
                map.put(val, idx++);
            }
        }
    }

    static void build() {
        for (int i = 0; i < arr.length; i++) {
            int k = map.get(arr[i]);
            update(1, 0, arr.length - 1, k, 1);
        }
    }

    static void update(int node, int start, int end, int i, int x) {
        if (start == end) {
            tree[node] += x;
            return;
        }

        int mid = (start + end) / 2;

        if (i <= mid) {
            update(2 * node, start, mid, i, x);
        } else {
            update(2 * node + 1, mid + 1, end, i, x);
        }

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    static int query(int node, int start, int end, int l, int r) {
        if (start >= l && end <= r) {
            return tree[node];
        }

        if (start > r || end < l) {
            return 0;
        }

        int mid = (start + end) / 2;

        return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n];

        allVals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            allVals.add(arr[i]);
        }

        quers = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("?")) {
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);
                quers.add(new Queries(1, a, b));
                allVals.add(a);
                allVals.add(b);
            } else {
                int k = Integer.parseInt(parts[1]);
                int x = Integer.parseInt(parts[2]);
                quers.add(new Queries(2, k, x));
                allVals.add(x);
            }
        }

        map = new HashMap<>();
        compressIndexes();

        tree = new int[4 * n];
        build();

        for (int i = 0; i < q; i++) {
            Queries quer = quers.get(i);
            if (quer.type == 1) {
                int a = quer.a;
                int b = quer.b;

                a = map.get(a);
                b = map.get(b);

                out.println(query(1, 0, n - 1, a, b));
            } else {
                int k = quer.a - 1;
                int x = quer.b;

                update(1, 0, n - 1, map.get(arr[k]), -1);
                arr[k] = x;
                update(1, 0, n - 1, map.get(x), 1);
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
