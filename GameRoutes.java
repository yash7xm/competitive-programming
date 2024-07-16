import java.util.*;

public class GameRoutes {

    static ArrayList<Integer> topsort;
    static ArrayList<ArrayList<Integer>> graph;

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
        }

        topsort = new ArrayList<>();

        topSort(n);

        int mod = 1000000007;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int idx = topsort.get(i);
            if (idx == n) {
                dp[idx] = 1;
            } else {
                for (int v : graph.get(idx)) {
                    dp[idx] += dp[v] % mod;
                }
            }
        }

        System.out.println(dp[1]);

        scn.close();
    }

    private static void topSort(int n) {
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

        while (q.size() > 0) {
            int u = q.removeFirst();

            topsort.add(u);

            for (int v : graph.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.add(v);
                }
            }
        }
    }
}
