import java.util.*;

public class LongestFlightRoute {

    public static class Pair implements Comparable<Pair> {
        int vtx;
        int wt;

        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return Integer.compare(o.wt, this.wt);
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
            int wt = 1;

            graph.get(u).add(new Pair(v, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));
        int[] path = new int[n + 1];
        Arrays.fill(path, Integer.MIN_VALUE);
        int[] parent = new int[n + 1];
        parent[1] = -1;
        path[1] = 0;

        while (pq.size() > 0) {
            Pair rem = pq.poll();

            if (rem.wt < path[rem.vtx])
                continue;

            path[rem.vtx] = rem.wt;

            for (Pair nbr : graph.get(rem.vtx)) {
                pq.add(new Pair(nbr.vtx, nbr.wt + rem.wt));
                parent[nbr.vtx] = rem.vtx;
            }
        }

        if (path[n] == Integer.MIN_VALUE) {
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
}
