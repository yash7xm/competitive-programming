package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BuildingTeams {
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

        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);

        boolean flag = true;
        for (int i = 1; i <= n && flag; i++) {
            for (int nbr : graph.get(i)) {
                if (!flag)
                    break;
                if (vis[nbr] == -1) {
                    flag = bfs(graph, vis, nbr);
                }
            }
        }

        if (!flag) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= n; i++) {
                if (vis[i] % 2 != 0 || vis[i] == -1) {
                    System.out.print("2 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }

        scn.close();
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int[] vis, int vtx) {
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(vtx);

        int lvl = 0;
        while (q.size() > 0) {
            int n = q.size();
            lvl++;

            while (n-- > 0) {
                int rem = q.removeFirst();

                if (vis[rem] != -1)
                    continue;

                vis[rem] = lvl;

                for (int nbr : graph.get(rem)) {
                    if (vis[nbr] != -1) {
                        if (vis[nbr] == lvl) {
                            return false;
                        }
                    } else {
                        q.add(nbr);
                    }
                }
            }
        }
        return true;
    }
}
