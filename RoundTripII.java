import java.util.*;

public class RoundTripII {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] vis;
    static boolean[] isPresent;
    static Stack<Integer> st;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
        }

        vis = new boolean[n + 1];
        isPresent = new boolean[n + 1];
        st = new Stack<>();

        for (int u = 1; u <= n; u++) {
            if (!vis[u]) {
                if (dfs(u))
                    break;
            }
        }

        if (st.size() == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            int s = st.pop();
            ArrayList<Integer> res = new ArrayList<>();
            res.add(s);
            while (st.peek() != s) {
                res.add(st.pop());
            }
            res.add(s);

            System.out.println(res.size());

            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print(res.get(i) + " ");
            }
        }

        scn.close();
    }

    public static boolean dfs(int u) {
        vis[u] = true;
        st.push(u);
        isPresent[u] = true;

        for (int v : graph.get(u)) {
            if (!vis[v]) {
                if (dfs(v))
                    return true;
            }

            if (isPresent[v]) {
                st.push(v);
                return true;
            }
        }

        st.pop();
        isPresent[u] = false;
        return false;
    }
}
