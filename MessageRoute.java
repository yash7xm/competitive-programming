import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MessageRoute {

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

        boolean[] vis = new boolean[n + 1];
        String res = bfs(graph, vis);

        if (res.equals("!")) {
            System.out.println("IMPOSSIBLE");
        } else {
            String[] parts = res.split(" ");
            System.out.println(parts.length);
            System.out.println(res);
        }

        scn.close();
    }

    public static class Pair {
        int vtx;
        String psf;

        Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static String bfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair(1, "1"));

        while (q.size() > 0) {
            Pair rem = q.removeFirst();

            if (vis[rem.vtx])
                continue;

            vis[rem.vtx] = true;

            if (rem.vtx == graph.size() - 1) {
                return rem.psf.trim();
            }

            for (int nbr : graph.get(rem.vtx)) {
                if (!vis[nbr]) {
                    q.addLast(new Pair(nbr, rem.psf + " " + nbr));
                }
            }

        }

        return "!";
    }
}
