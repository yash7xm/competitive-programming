import java.util.*;
import java.io.*;

public class CatAndTree {
    static boolean[] isOccupied;
    static int[] parent;
    static int[][] dp;
    static int MAX = 18;

    static void build(int n) {
        dp = new int[MAX + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] = parent[i];
        }
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i - 1][j] != 0) {
                    dp[i][j] = dp[i - 1][dp[i - 1][j]];
                }
            }
        }
    }

    static int query(int curr) {
        if (isOccupied[curr])
            return 0;

        int j = 1;
        for (int i = MAX; i >= 0; i--) {
            int jp = dp[i][curr];

            if (!isOccupied[jp]) {
                curr = jp;
                j += 1 << i;
            }
        }
        isOccupied[curr] = true;
        return j;
    }

    static void setBit(int n) {
        MAX = 0;
        while ((1 << MAX) <= n) {
            MAX++;
        }
        MAX--;
    }

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scn.nextInt();
        setBit(n);
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int p = scn.nextInt();
            parent[i] = p;
        }

        build(n);

        int[] cat = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cat[i] = scn.nextInt();
        }

        isOccupied = new boolean[n + 1];
        isOccupied[0] = true;
        for (int i = 1; i <= n; i++) {
            out.println(query(cat[i]));
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
