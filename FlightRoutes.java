import java.util.*;

public class FlightRoutes {

    public static class Pair implements Comparable<Pair> {
        int vtx;
        long wt;

        Pair(int vtx, long wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.wt, o.wt);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph.get(u).add(new Pair(v, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        PriorityQueue<Long> res = new PriorityQueue<>();
        long[] path = new long[n + 1];
        pq.add(new Pair(1, 0));

        while (pq.size() > 0) {
            Pair rem = pq.poll();

            path[rem.vtx] = rem.wt;

            if (rem.vtx == n) {
                res.add(path[rem.vtx]);
                k--;
            }

            if (k == 0)
                break;

            for (Pair nbr : graph.get(rem.vtx)) {
                pq.add(new Pair(nbr.vtx, rem.wt + nbr.wt));
            }

        }

        while (res.size() > 0) {
            System.out.print(res.poll() + " ");
        }

        scn.close();
    }
}
