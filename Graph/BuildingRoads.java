package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BuildingRoads {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() == 0) {
                graph.get(i).add(i);
            }
        }

        boolean[] vis = new boolean[n + 1];

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int nbr : graph.get(i)) {
                if (!vis[nbr]) {
                    bfs(graph, vis, nbr);
                    res.add(nbr);
                }
            }
        }

        System.out.println(res.size() - 1);
        if (res.size() - 1 > 0) {
            for (int i = 1; i < res.size(); i++) {
                System.out.println(res.get(0) + " " + res.get(i));
            }
        }
        scn.close();
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int vtx) {
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(vtx);

        while (q.size() > 0) {
            int rem = q.removeFirst();

            if (vis[rem])
                continue;
            vis[rem] = true;

            for (int nbr : graph.get(rem)) {
                if (!vis[nbr]) {
                    q.add(nbr);
                }
            }

        }
    }
}
