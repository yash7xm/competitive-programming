package Graph;
import java.util.*;
import java.io.*;

public class CoinCollector {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int val[], component[];
    static List<List<Integer>> adj, adjRev, adjScc;
    static List<Long> sccVal;
    static List<Integer> topSort;
    static boolean vis[];
    static Stack<Integer> st;

    static void dfs1(int u) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                dfs1(v);
            }
        }
        st.push(u);
    }

    static void dfs2(int u, int comp, long[] sum) {
        component[u] = comp;
        sum[0] += val[u];
        for (int v : adjRev.get(u)) {
            if (component[v] == -1) {
                dfs2(v, comp, sum);
            }
        }
    }

    static void build(int n, int comp) {
        adjScc = new ArrayList<>();
        for (int i = 0; i < comp; i++) {
            adjScc.add(new ArrayList<>());
        }

        for (int u = 1; u <= n; u++) {
            for (int v : adj.get(u)) {
                if (component[u] != component[v]) {
                    adjScc.get(component[u]).add(component[v]);
                }
            }
        }
    }

    static void topologicalSort(int n) {
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int v : adjScc.get(i)) {
                indeg[v]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.addLast(i);
            }
        }

        while (q.size() > 0) {
            int rem = q.removeFirst();
            topSort.add(rem);
            for (int v : adjScc.get(rem)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.addLast(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        val = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            val[i] = in.nextInt();
        }
        adj = new ArrayList<>();
        adjRev = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            adj.get(u).add(v);
            adjRev.get(v).add(u);
        }

        vis = new boolean[n + 1];
        st = new Stack<>();
        for (int u = 1; u <= n; u++) {
            if (!vis[u]) {
                dfs1(u);
            }
        }

        component = new int[n + 1];
        Arrays.fill(component, -1);
        int comp = 0;
        sccVal = new ArrayList<>();
        while (!st.isEmpty()) {
            int u = st.pop();
            if (component[u] == -1) {
                long[] sum = new long[1];
                dfs2(u, comp++, sum);
                sccVal.add(sum[0]);
            }
        }

        topSort = new ArrayList<>();
        build(n, comp);
        topologicalSort(comp);

        long[] dp = new long[comp];
        long max = 0;
        for (int u : topSort) {
            dp[u] += sccVal.get(u);
            for (int v : adjScc.get(u)) {
                dp[v] = Math.max(dp[v], dp[u]);
            }
            max = Math.max(dp[u], max);
        }

        out.println(max);

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
