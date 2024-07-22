import java.util.*;
import java.io.*;

public class GiantPizza {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static List<List<Integer>> adj;
    static List<List<Integer>> adjRev;
    static int component[];
    static boolean assignment[], vis[];
    static Stack<Integer> st;
    static int n, m;

    static int negate(int x) {
        return x < n ? x + n : x - n;
    }

    static void addClause(int x, int y) {
        adj.get(negate(x)).add(y);
        adj.get(negate(y)).add(x);
        adjRev.get(y).add(negate(x));
        adjRev.get(x).add(negate(y));
    }

    static void dfs1(int u) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                dfs1(v);
            }
        }
        st.push(u);
    }

    static void dfs2(int u, int comp) {
        component[u] = comp;
        for (int v : adjRev.get(u)) {
            if (component[v] == -1) {
                dfs2(v, comp);
            }
        }
    }

    public static void main(String[] args) {
        m = in.nextInt();
        n = in.nextInt();

        adj = new ArrayList<>();
        adjRev = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            int x, y;

            if (parts[0].equals("+")) {
                x = Integer.parseInt(parts[1]) - 1;
            } else {
                x = negate(Integer.parseInt(parts[1]) - 1);
            }

            if (parts[2].equals("+")) {
                y = Integer.parseInt(parts[3]) - 1;
            } else {
                y = negate(Integer.parseInt(parts[3]) - 1);
            }

            addClause(x, y);
        }

        st = new Stack<>();
        vis = new boolean[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (!vis[i]) {
                dfs1(i);
            }
        }

        component = new int[2 * n];
        Arrays.fill(component, -1);
        int comp = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            if (component[u] == -1) {
                dfs2(u, comp++);
            }
        }

        boolean flag = true;
        assignment = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (component[i] == component[negate(i)]) {
                flag = false;
                break;
            }

            assignment[i] = component[i] > component[negate(i)];
        }

        if (!flag) {
            out.println("IMPOSSIBLE");
        } else {
            for (int i = 0; i < n; i++) {
                if (assignment[i]) {
                    out.print("+ ");
                } else {
                    out.print("- ");
                }
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
                if (st != null && st.hasMoreTokens()) {
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
