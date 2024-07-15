import java.util.*;

public class HighScore {

    public static class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static ArrayList<ArrayList<Integer>> g;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        Edge[] graph = new Edge[m];
        g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph[i] = new Edge(u, v, wt);
            g.get(u).add(v);
        }

        long[] path = new long[n + 1];
        Arrays.fill(path, Long.MIN_VALUE);
        path[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = graph[j].u;
                int v = graph[j].v;
                int wt = graph[j].wt;

                if (path[u] == Long.MIN_VALUE) {
                    continue;
                }

                if (path[u] + wt > path[v]) {
                    path[v] = path[u] + wt;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < m; j++) {
            int u = graph[j].u;
            int v = graph[j].v;
            int wt = graph[j].wt;

            if (path[u] == Long.MIN_VALUE) {
                continue;
            }

            if (path[u] + wt > path[v]) {
                path[v] = path[u] + wt;
                set.add(v);
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();

        LinkedList<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        q.addLast(1);

        while (q.size() > 0) {
            int rem = q.removeFirst();

            if (vis[rem])
                continue;

            vis[rem] = true;

            if (set.contains(rem)) {
                queue.addLast(rem);
            }

            for (int nbrs : g.get(rem)) {
                if (!vis[nbrs]) {
                    q.addLast(nbrs);
                }
            }
        }

        vis = new boolean[n + 1];
        boolean flag = false;

        while (queue.size() > 0) {
            int rem = queue.removeFirst();

            if (vis[rem])
                continue;

            vis[rem] = true;

            if (rem == n) {
                flag = true;
                break;
            }

            for (int nbrs : g.get(rem)) {
                if (!vis[nbrs]) {
                    queue.addLast(nbrs);
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(path[n]);
        }

        scn.close();
    }
}
