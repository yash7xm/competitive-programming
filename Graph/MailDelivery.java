package Graph;
import java.util.*;
import java.io.*;

public class MailDelivery {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Pair {
        int node;
        int idx;

        Pair(int node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    static List<List<Pair>> graph;
    static int deg[];
    static boolean seen[];
    static List<Integer> path;

    static void dfs(int node) {
        while (!graph.get(node).isEmpty()) {
            Pair edge = graph.get(node).remove(graph.get(node).size() - 1);
            if (seen[edge.idx])
                continue;
            seen[edge.idx] = true;
            dfs(edge.node);
        }
        path.add(node);
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        deg = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            graph.get(u).add(new Pair(v, i));
            graph.get(v).add(new Pair(u, i));
            deg[u]++;
            deg[v]++;
        }

        for (int i = 1; i <= n; i++) {
            if (deg[i] % 2 != 0) {
                out.println("IMPOSSIBLE");
                out.flush();
                return;
            }
        }

        seen = new boolean[m + 1];
        path = new ArrayList<>();

        dfs(1);

        if (path.size() != m + 1) {
            out.println("IMPOSSIBLE");
        } else {
            for (int i = path.size() - 1; i >= 0; i--) {
                out.print(path.get(i) + " ");
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
