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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        Edge[] graph = new Edge[m];
        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph[i] = new Edge(u, v, wt);
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

        long ans = path[n];

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

        if (path[n] > ans) {
            ans = -1;
        }

        System.out.println(ans);

        scn.close();
    }
}
