import java.util.ArrayList;
import java.util.Scanner;

public class RoundTrip {
    static int[] parent;
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> graph;
    static int cycleStart, cycleEnd;

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

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[n + 1];
        vis = new boolean[n + 1];
        cycleStart = -1;

        for (int i = 1; i <= n; i++) {
            if (!vis[i] && cycleStart == -1) {
                if (dfs(i, -1)) {
                    break;
                }
            }
        }

        if (cycleStart == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> cycle = new ArrayList<>();
            cycle.add(cycleStart);
            for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                cycle.add(v);
            }
            cycle.add(cycleStart);

            System.out.println(cycle.size());
            for (int i = cycle.size() - 1; i >= 0; i--) {
                System.out.print(cycle.get(i) + " ");
            }
            System.out.println();
        }

        scn.close();
    }

    private static boolean dfs(int vtx, int par) {
        vis[vtx] = true;
        for (int nbr : graph.get(vtx)) {
            if (nbr == par) {
                continue;
            }
            if (vis[nbr]) {
                cycleStart = nbr;
                cycleEnd = vtx;
                return true;
            }
            parent[nbr] = vtx;
            if (dfs(nbr, vtx)) {
                return true;
            }
        }
        return false;
    }
}
