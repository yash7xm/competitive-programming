import java.util.*;

public class LongestFlightRoute {

    public static class Pair {
        int vtx;
        int wt;

        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = -1;

            graph.get(u).add(new Pair(v, wt));
        }

        ArrayList<Integer> topsort = new ArrayList<>();

        topSort(topsort, graph);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < topsort.size(); i++) {
            int u = topsort.get(i);

            if (dist[u] != Integer.MAX_VALUE) {
                for (Pair nbr : graph.get(u)) {
                    int newdist = dist[u] + nbr.wt;
                    if (newdist < dist[nbr.vtx]) {
                        dist[nbr.vtx] = newdist;
                        parent[nbr.vtx] = u;
                    }
                }
            }
        }

        if (dist[n] == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = n; i != 1; i = parent[i]) {
                res.add(i);
            }
            res.add(1);

            System.out.println(res.size());
            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print(res.get(i) + " ");
            }
        }

        scn.close();
    }

    public static void topSort(ArrayList<Integer> topsort, ArrayList<ArrayList<Pair>> graph) {
        int n = graph.size();
        int[] indeg = new int[n];

        for (int i = 1; i < n; i++) {
            for (Pair nbr : graph.get(i)) {
                indeg[nbr.vtx]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            if (indeg[i] == 0) {
                q.addLast(i);
            }
        }

        while (q.size() > 0) {
            int u = q.removeFirst();

            topsort.add(u);

            for (Pair nbr : graph.get(u)) {
                indeg[nbr.vtx]--;
                if (indeg[nbr.vtx] == 0) {
                    q.add(nbr.vtx);
                }
            }
        }
    }
}
