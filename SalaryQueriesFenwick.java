import java.util.*;
import java.io.*;

public class SalaryQueriesFenwick {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] arr;
    static int[] farr = new int[100000001];

    static void build() {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            while (k < farr.length) {
                farr[k]++;
                k += (k & -k);
            }
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

    static void update(int k, int x) {
        int i = arr[k];
        while (i < farr.length) {
            farr[i]--;
            i += (i & -i);
        }

        while (x < farr.length) {
            farr[x]++;
            x += (x & -x);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        build();

        for (int i = 0; i < q; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("?")) {
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);

                int res = 0;
                res = query(b) - query(a - 1);
                out.println(res);
            } else {
                int k = Integer.parseInt(parts[1]);
                int x = Integer.parseInt(parts[2]);

                update(k, x);
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
