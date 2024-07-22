import java.util.*;
import java.io.*;

public class PlanetsAndKingdoms {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> revGraph;
    static ArrayList<ArrayList<Integer>> components;
    static Stack<Integer> st;
    static boolean vis[];

    static void stackFillingDfs(int u) {
        if (vis[u])
            return;

        vis[u] = true;

        for (int v : graph.get(u)) {
            if (!vis[v]) {
                stackFillingDfs(v);
            }
        }
        st.push(u);
    }

    static void dfs(int u, ArrayList<Integer> comp) {
        if (vis[u])
            return;

        vis[u] = true;
        comp.add(u);

        for (int v : revGraph.get(u)) {
            if (!vis[v]) {
                dfs(v, comp);
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
                stackFillingDfs(i);
            }
        }

        vis = new boolean[n + 1];
        components = new ArrayList<>();
        while (st.size() > 0) {
            int u = st.pop();
            if (!vis[u]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(u, comp);
                components.add(comp);
            }
        }

        int[] arr = new int[n + 1];
        int k = 0;
        for (ArrayList<Integer> comp : components) {
            k++;
            for (int vtx : comp) {
                arr[vtx] = k;
            }
        }

        out.println(k);
        for (int i = 1; i <= n; i++) {
            out.print(arr[i] + " ");
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
