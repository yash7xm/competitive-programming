package Graph;
import java.util.*;
import java.io.*;

public class PlanetsCycles {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int arr[], dp[];
    static boolean vis[];
    static Stack<Integer> st;
    static Stack<Integer> stk;
    static ArrayList<ArrayList<Integer>> graph;

    static void dfs(int i) {

        stk.push(i);

        while (stk.size() > 0) {
            int u = stk.pop();

            if (vis[u])
                continue;
            vis[u] = true;

            st.push(u);
            arr[u] = st.size();
            for (int v : graph.get(u)) {
                if (!vis[v]) {
                    stk.push(v);
                } else {
                    if (dp[v] == 0) {
                        int cost = arr[u] - arr[v] + 1;
                        while (st.size() > 0) {
                            int rem = st.pop();
                            dp[rem] = cost;
                            arr[rem] = 1;
                            if (rem == v) {
                                break;
                            }
                        }
                        cost++;
                        while (st.size() > 0) {
                            int rem = st.pop();
                            dp[rem] = cost;
                            arr[rem] = 1;
                            cost++;
                        }
                    } else {
                        int cost = dp[v] + 1;
                        while (st.size() > 0) {
                            int rem = st.pop();
                            dp[rem] = cost;
                            arr[rem] = 1;
                            cost++;
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        arr = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            graph.get(i).add(arr[i]);
        }

        vis = new boolean[n + 1];
        dp = new int[n + 1];
        st = new Stack<>();
        stk = new Stack<>();
        arr = new int[n + 1];
        Arrays.fill(arr, 1);

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            out.print(dp[i] + " ");
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
