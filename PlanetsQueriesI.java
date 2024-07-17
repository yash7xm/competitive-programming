import java.util.*;
import java.io.*;

public class PlanetsQueriesI {

    static int MAX = 30;
    static int[][] table;

    static void build(int[] p) {
        int n = p.length;
        table = new int[MAX][n];

        for (int i = 0; i < n; i++) {
            table[0][i] = p[i];
        }

        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = table[i - 1][table[i - 1][j]];
            }
        }
    }

    static int query(int a, int k) {
        for (int i = 0; i < MAX; i++) {
            int mask = (1 << i);
            if ((mask & k) > 0) {
                a = table[i][a];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scn.nextInt();
        int q = scn.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scn.nextInt() - 1;
        }

        build(p);

        for (int i = 0; i < q; i++) {
            int a = scn.nextInt() - 1;
            int k = scn.nextInt();

            out.println(query(a, k) + 1);
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