package Graph;
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
                dfs(i, -1);
                if (cycleStart != -1)
                    break;
            }
        }

        if (cycleStart == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(cycleStart);
            for (int i = cycleStart; i > 0 && i != cycleEnd; i = parent[i]) {
                res.add(parent[i]);
            }
            res.add(cycleStart);

            System.out.println(res.size());
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
        }

        scn.close();
    }

    private static void dfs(int vtx, int par) {
        vis[vtx] = true;
        parent[vtx] = par;

        for (int nbr : graph.get(vtx)) {
            if (nbr == par) {
                continue;
            }

            if (vis[nbr]) {
                cycleStart = nbr;
                cycleEnd = vtx;
                return;
            } else {
                dfs(nbr, vtx);
            }
        }
    }
}
