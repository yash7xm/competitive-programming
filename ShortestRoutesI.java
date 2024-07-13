import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestRoutesI {

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] vis;

    public static class Edge implements Comparable<Edge> {
        int vtx;
        int wt;

        Edge(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph.get(u).add(new Edge(v, wt));
            graph.get(v).add(new Edge(v, wt));
        }

        vis = new int[n + 1];
        Arrays.fill(vis, -1);

        bfs();

        for (int i = 1; i <= n; i++) {
            System.out.print(vis[i] + " ");
        }

        scn.close();
    }

    private static void bfs() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (pq.size() > 0) {
            Edge rem = pq.poll();

            if (vis[rem.vtx] != -1)
                continue;

            vis[rem.vtx] = rem.wt;

            for (Edge nbr : graph.get(rem.vtx)) {
                if (vis[nbr.vtx] == -1) {
                    pq.add(new Edge(nbr.vtx, nbr.wt + rem.wt));
                }
            }
        }
    }
}
