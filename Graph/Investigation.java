package Graph;
import java.util.*;

public class Investigation {

    public static class Edge implements Comparable<Edge> {
        int vtx;
        long wt;

        Edge(int vtx, long wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Edge o) {
            return Long.compare(this.wt, o.wt);
        }
    }

    public static class Node {
        long min;
        int ways;
        int minc;
        int maxc;

        Node(long min, int ways, int minc, int maxc) {
            this.min = min;
            this.ways = ways;
            this.minc = minc;
            this.maxc = maxc;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;

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

        Node[] dp = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = new Node(Long.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        dp[1] = new Node(0, 1, 0, 0);
        int mod = 1000000007;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (pq.size() > 0) {
            Edge rem = pq.poll();

            long newDist = rem.wt;
            if (newDist > dp[rem.vtx].min)
                continue;

            for (Edge nbr : graph.get(rem.vtx)) {
                newDist = rem.wt + nbr.wt;
                if (newDist < dp[nbr.vtx].min) {
                    dp[nbr.vtx].min = newDist;
                    dp[nbr.vtx].ways = dp[rem.vtx].ways;
                    dp[nbr.vtx].minc = dp[rem.vtx].minc + 1;
                    dp[nbr.vtx].maxc = dp[rem.vtx].maxc + 1;
                    pq.add(new Edge(nbr.vtx, rem.wt + nbr.wt));
                } else if (newDist == dp[nbr.vtx].min) {
                    dp[nbr.vtx].ways = (dp[nbr.vtx].ways + dp[rem.vtx].ways) % mod;
                    dp[nbr.vtx].minc = Math.min(dp[nbr.vtx].minc, dp[rem.vtx].minc + 1);
                    dp[nbr.vtx].maxc = Math.max(dp[nbr.vtx].maxc, dp[rem.vtx].maxc + 1);
                }
            }
        }

        System.out.println(dp[n].min + " " + dp[n].ways + " " + dp[n].minc + " " + dp[n].maxc);

        scn.close();
    }
}
