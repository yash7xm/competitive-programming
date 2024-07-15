import java.util.*;

public class CycleFinding {

    public static class Pair {
        int u;
        int v;
        long wt;

        Pair(int u, int v, long wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static class Edge {
        int vtx;
        long wt;

        Edge(int vtx, long wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        Pair[] graph = new Pair[m + n];
        ArrayList<ArrayList<Edge>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph[i] = (new Pair(u, v, wt));
            g.get(u).add(new Edge(v, wt));
        }

        for (int i = m, j = 1; i < n + m; i++, j++) {
            graph[i] = new Pair(0, j, 0);
        }

        long[] path = new long[n + 1];
        int[] relaxant = new int[n + 1];
        Arrays.fill(path, Long.MAX_VALUE);
        path[0] = 0;
        int x = -1;

        for (int i = 0; i <= n; i++) {
            x = -1;
            for (int j = 0; j < m + n; j++) {
                int u = graph[j].u;
                int v = graph[j].v;
                long wt = graph[j].wt;

                if (path[u] == Long.MAX_VALUE) {
                    continue;
                }

                if (path[u] + wt < path[v]) {
                    path[v] = path[u] + wt;
                    relaxant[v] = u;
                    x = v;
                }
            }
        }

        if (x == -1) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < n; i++) {
                x = relaxant[x];
            }

            ArrayList<Integer> res = new ArrayList<>();
            for (int i = x;; i = relaxant[i]) {
                res.add(i);
                if (i == x && res.size() > 1) {
                    break;
                }
            }

            System.out.println("YES");
            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print(res.get(i) + " ");
            }
        }

        scn.close();
    }
}
