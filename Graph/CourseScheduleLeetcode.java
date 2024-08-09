package Graph;

import java.util.*;

public class CourseScheduleLeetcode {
    public static void main(String[] args) {

    }

    public int[] findOrder(int n, int[][] p) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < p.length; i++) {
            int u = p[i][0];
            int v = p[i][1];

            graph.get(v).add(u);
        }

        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int v : graph.get(i)) {
                indeg[v]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.addLast(i);
            }
        }

        int[] res = new int[n];
        int i = 0;

        while (q.size() > 0) {
            int u = q.removeFirst();

            res[i] = u;
            i++;

            for (int v : graph.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.addLast(v);
                }
            }
        }

        if (n != i) {
            return new int[1];
        }

        return res;
    }
}