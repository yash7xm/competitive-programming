import java.util.*;

public class Investigation {

    public static class Edge {
        int vtx;
        long wt;

        Edge(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    public static class Node {
        long min;
        int numOfMin;
        int minVtxInMin;
        int maxVtxInMin;

        Node(long min, int numOfMin, int minVtxInMin, int maxVtxInMin) {
            this.min = min;
            this.numOfMin = numOfMin;
            this.minVtxInMin = minVtxInMin;
            this.maxVtxInMin = maxVtxInMin;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static ArrayList<Integer> topsort;

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
            int wt = scn.nextInt();

            graph.get(u).add(new Edge(v, wt));
        }

        topsort = new ArrayList<>();
        topSort(n);

        Node[] dp = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = new Node(Long.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        dp[1] = new Node(0, 1, 0, 0);
        int mod = 1000000007;

        for (int i = 0; i < topsort.size(); i++) {
            int idx = topsort.get(i);

            if (dp[idx].min != Integer.MAX_VALUE) {
                for (Edge nbr : graph.get(idx)) {
                    long newDist = nbr.wt + dp[idx].min;
                    if (newDist < dp[nbr.vtx].min) {
                        dp[nbr.vtx].min = newDist;
                        dp[nbr.vtx].numOfMin = dp[idx].numOfMin;
                        dp[nbr.vtx].minVtxInMin = dp[idx].minVtxInMin + 1;
                        dp[nbr.vtx].maxVtxInMin = dp[idx].maxVtxInMin + 1;
                    } else if (newDist == dp[nbr.vtx].min) {
                        dp[nbr.vtx].numOfMin = (dp[nbr.vtx].numOfMin + dp[idx].numOfMin) % mod;
                        dp[nbr.vtx].minVtxInMin = Math.min(dp[nbr.vtx].minVtxInMin, dp[idx].minVtxInMin + 1);
                        dp[nbr.vtx].maxVtxInMin = Math.max(dp[nbr.vtx].maxVtxInMin, dp[idx].maxVtxInMin + 1);
                    }
                }
            }
        }

        System.out.println(dp[n].min + " " + dp[n].numOfMin + " " + dp[n].minVtxInMin + " " + dp[n].maxVtxInMin);

        scn.close();
    }

    private static void topSort(int n) {
        boolean[] vis = new boolean[n + 1];
        Stack<Integer> st = new Stack<>();

        for (int u = 1; u <= n; u++) {
            if (!vis[u]) {
                sort(u, vis, st);
            }
        }

        while (st.size() > 0) {
            topsort.add(st.pop());
        }
    }

    private static void sort(int u, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        for (Edge e : graph.get(u)) {
            if (!vis[e.vtx]) {
                sort(e.vtx, vis, st);
            }
        }
        st.push(u);
    }
}
