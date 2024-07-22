package Graph;
import java.util.*;
import java.io.*;

public class FlightRoutesCheck {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static ArrayList<ArrayList<Integer>> graph1;
    static ArrayList<ArrayList<Integer>> graph2;
    static boolean vis[];

    static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        if (vis[u])
            return;
        vis[u] = true;
        for (int v : graph.get(u)) {
            if (!vis[v])
                dfs(v, graph);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            graph1.get(u).add(v);
            graph2.get(v).add(u);
        }

        vis = new boolean[n + 1];
        dfs(1, graph1);
        for (int i = 1; i <= n; i++) {
            if (vis[i] == false) {
                out.println("NO");
                out.println(1 + " " + i);
                out.flush();
                return;
            }
        }

        vis = new boolean[n + 1];
        dfs(1, graph2);
        for (int i = 1; i <= n; i++) {
            if (vis[i] == false) {
                out.println("NO");
                out.println(i + " " + 1);
                out.flush();
                return;
            }
        }

        out.println("YES");
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
