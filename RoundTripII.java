import java.util.*;

public class RoundTripII {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] vis;
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
        st = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                stDfs(i);
            }
        }

        ArrayList<ArrayList<Integer>> newGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            newGraph.add(new ArrayList<>());
        }

        for (int u = 1; u <= n; u++) {
            for (int v : graph.get(u)) {
                newGraph.get(v).add(u);
            }
        }

        vis = new boolean[n + 1];
        boolean flag = false;
        while (st.size() > 0) {
            int rem = st.pop();
            if (!vis[rem]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(rem, comp, newGraph);
                if (comp.size() > 1) {
                    flag = true;
                    System.out.println(comp.size() + 1);
                    for (int i = comp.size() - 1; i >= 0; i--) {
                        System.out.print(comp.get(i) + " ");
                    }
                    System.out.print(comp.get(comp.size() - 1));
                    break;
                }
            }
        }

        if (flag == false) {
            System.out.println("IMPOSSIBLE");
        }

        scn.close();
    }

    public static void dfs(int i, ArrayList<Integer> comp, ArrayList<ArrayList<Integer>> newGraph) {
        if (vis[i])
            return;

        vis[i] = true;
        comp.add(i);

        for (int nbr : newGraph.get(i)) {
            if (!vis[nbr]) {
                dfs(nbr, comp, newGraph);
            } else
                return;
        }
    }

    public static void stDfs(int i) {

        if (vis[i])
            return;

        vis[i] = true;

        for (int nbr : graph.get(i)) {
            if (!vis[nbr]) {
                stDfs(nbr);
            }
        }

        st.push(i);
    }
}
