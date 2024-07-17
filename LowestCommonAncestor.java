import java.util.*;
import java.io.*;

public class LowestCommonAncestor {

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

    static ArrayList<ArrayList<Integer>> graph;
    static int[] parent;
    static int[] level;
    static boolean[] vis;
    static int[][] table;
    static int MAXBIT = 18;

    public static void build(int n) {
        table = new int[MAXBIT + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            table[0][i] = parent[i];
        }

        for (int i = 1; i <= MAXBIT; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i - 1][table[i - 1][j]];
            }
        }
    }

    public static int lca(int u, int v) {
        if (level[v] < level[u]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int k = level[v] - level[u];

        for (int i = MAXBIT; i >= 0; i--) {
            if ((k & (1 << i)) > 0) {
                v = table[i][v];
            }
        }

        if (u == v) {
            return u;
        }

        for (int i = MAXBIT; i >= 0; i--) {
            if (table[i][u] != table[i][v]) {
                u = table[i][u];
                v = table[i][v];
            }
        }
        return parent[u];
    }

    public static void main(String[] args) throws IOException {
        FastReader scn = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = scn.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            out.println("Case " + tc + ":");
            int n = scn.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                int count = scn.nextInt();
                for (int j = 0; j < count; j++) {
                    int v = scn.nextInt();
                    graph.get(i).add(v);
                }
            }

            parent = new int[n + 1];
            level = new int[n + 1];
            vis = new boolean[n + 1];

            dfs(1, 1);

            build(n);

            int q = scn.nextInt();
            while (q-- > 0) {
                int u = scn.nextInt();
                int v = scn.nextInt();

                out.println(lca(u, v));
            }
        }
        out.flush();
    }

    public static void dfs(int u, int lvl) {
        vis[u] = true;
        level[u] = lvl;

        for (int v : graph.get(u)) {
            if (!vis[v]) {
                parent[v] = u;
                dfs(v, lvl + 1);
            }
        }
    }
}
