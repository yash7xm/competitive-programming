package Range_Queries;
import java.util.*;
import java.io.*;

public class SalaryQueriesCompressedIndexFenwick {

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

    static int[] arr, farr;
    static List<Integer> allVals;
    static List<Queries> quers;
    static Map<Integer, Integer> map;

    static void compressIndexes() {
        Collections.sort(allVals);
        int idx = 1;

        for (int val : allVals) {
            if (!map.containsKey(val)) {
                map.put(val, idx++);
            }
        }
    }

    static void build() {
        for (int i = 1; i < arr.length; i++) {
            int j = map.get(arr[i]);
            update(j, 1);
        }
    }

    static void update(int i, int x) {
        while (i < farr.length) {
            farr[i] += x;
            i += (i & -i);
        }
    }

    static int query(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt += farr[x];
            x -= (x & -x);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n + 1];

        allVals = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
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

        farr = new int[map.size() + 1];
        build();

        for (int i = 0; i < q; i++) {
            Queries quer = quers.get(i);
            if (quer.type == 1) {
                int a = quer.a;
                int b = quer.b;

                a = map.get(a);
                b = map.get(b);

                out.println(query(b) - query(a - 1));
            } else {
                int k = quer.a;
                int x = quer.b;

                update(map.get(arr[k]), -1);
                arr[k] = x;
                update(map.get(x), 1);
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
