package Binary_Lifting;
import java.util.*;
import java.io.*;

public class LearningDishes {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Pair {
        int max;
        int count;

        Pair(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }

    static int val[], parent[], dp[][];
    static ArrayList<Integer>[] graph;
    static Pair[] up;
    static int maxbit;

    static void build(int n) {
        dp = new int[maxbit + 1][n + 1];

        dp[0] = parent;

        for (int i = 1; i <= maxbit; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
            }
        }
    }

    static int query(int u, int w) {

        if(w >= up[u].max) return 0;
        int a = u;
        for (int i = maxbit; i >= 0; i--) {
            int jp = dp[i][u];
            if (up[jp].max > w) {
                u = jp;
            }
        }
        return up[a].count - up[parent[u]].count;
    }

    static void dfs(int node, int max, int cost) {
        if (up[node] == null) {
            if (val[node] > max) {
                up[node] = new Pair(val[node], cost + 1);
                max = val[node];
                cost = cost + 1;
            } else {
                up[node] = new Pair(max, cost);
            }
        }

        for (int i : graph[node]) {
            dfs(i, max, cost);
        }
    }

    static void setBit(int n) {
        maxbit = 0;
        while ((1 << maxbit) <= n) {
            maxbit++;
        }
        maxbit--;
    }

    static void solve() {
        int n = in.nextInt();
        setBit(n);
        val = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            val[i] = in.nextInt();
        }
        parent = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = (new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            parent[i] = in.nextInt();
            graph[parent[i]].add(i);
        }

        up = new Pair[n + 1];
        up[0] = new Pair(0, 0);
        dfs(1, 0, 0);

        build(n);

        int q = in.nextInt();
        int pr = 0;
        while (q-- > 0) {
            int u = in.nextInt() ^ pr;
            int w = in.nextInt() ^ pr;

            pr = query(u, w);

            out.println(pr);
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
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
