package Graph;
import java.util.*;

public class FlightDiscount {

    public static class Pair implements Comparable<Pair> {
        int vtx;
        long wt;
        boolean c;

        Pair(int vtx, long wt, boolean c) {
            this.vtx = vtx;
            this.wt = wt;
            this.c = c;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.wt, o.wt);
        }
    }

    static ArrayList<ArrayList<Pair>> graph;

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

            graph.get(u).add(new Pair(v, wt, false));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0, false));
        long[][] path = new long[n + 1][2];
        for (long[] p : path) {
            Arrays.fill(p, Long.MAX_VALUE);
        }

        path[1][0] = 0;

        while (pq.size() > 0) {
            Pair rem = pq.poll();

            if (rem.wt > path[rem.vtx][rem.c ? 1 : 0]) {
                continue;
            }
            for (Pair nbr : graph.get(rem.vtx)) {
                if (!rem.c) {
                    long newWt = rem.wt + nbr.wt;
                    if (path[nbr.vtx][0] > newWt) {
                        path[nbr.vtx][0] = newWt;
                        pq.add(new Pair(nbr.vtx, newWt, false));
                    }

                    long disWt = rem.wt + nbr.wt / 2;
                    if (path[nbr.vtx][1] > disWt) {
                        path[nbr.vtx][1] = disWt;
                        pq.add(new Pair(nbr.vtx, disWt, true));
                    }
                } else {
                    long newWt = rem.wt + nbr.wt;
                    if (path[nbr.vtx][1] > newWt) {
                        path[nbr.vtx][1] = newWt;
                        pq.add(new Pair(nbr.vtx, newWt, true));
                    }
                }
            }
        }

        long res = Math.min(path[n][0], path[n][1]);
        System.out.println(res);

        scn.close();
    }
}
