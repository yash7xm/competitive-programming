import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
        }

        int[] indeg = new int[n + 1];
        for (int u = 1; u <= n; u++) {
            for (int v : graph.get(u)) {
                indeg[v]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.addLast(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (q.size() > 0) {
            int u = q.removeFirst();

            res.add(u);

            for (int v : graph.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.addLast(v);
                }
            }
        }

        if (res.size() != n) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
        }

        scn.close();
    }
}
