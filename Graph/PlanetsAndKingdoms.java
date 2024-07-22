package Graph;

import java.util.*;
import java.io.*;

public class PlanetsAndKingdoms {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> revGraph;
    static int[] component;
    static Stack<Integer> st;
    static boolean vis[];

    static void dfs1(int u) {
        vis[u] = true;
        for (int v : graph.get(u)) {
            if (!vis[v]) {
                dfs1(v);
            }
        }
        st.push(u);
    }

    static void dfs2(int u, int comp) {
        component[u] = comp;
        for (int v : revGraph.get(u)) {
            if (component[v] == -1) {
                dfs2(v, comp);
            }
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        revGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            graph.get(u).add(v);
            revGraph.get(v).add(u);
        }

        st = new Stack<>();
        vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs1(i);
            }
        }

        component = new int[n + 1];
        Arrays.fill(component, -1);
        int comp = 1;
        while (st.size() > 0) {
            int u = st.pop();
            if (component[u] == -1) {
                dfs2(u, comp++);
            }
        }

        out.println(comp - 1);
        for (int i = 1; i <= n; i++) {
            out.print(component[i] + " ");
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
