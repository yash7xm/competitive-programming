import java.util.*;

public class ClearDebts {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int n = 3;
        System.out.println(getMinTransactions(n, list));
    }

    static int N = 10, count = 0;
    static List<List<Node>> graph;
    static boolean[] seen;

    public static class Node {
        int u;
        int v;
        int amt;
        int haveAmt;
        int idx;

        Node(int u, int v, int amt, int haveAmt, int idx) {
            this.u = u;
            this.v = v;
            this.amt = amt;
            this.haveAmt = haveAmt;
            this.idx = idx;
        }
    }

    public static int getMinTransactions(int n, List<List<Integer>> list) {
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < list.size(); i++) {
            int u = list.get(i).get(0);
            int v = list.get(i).get(1);
            int amt = list.get(i).get(2);

            graph.get(u).add(new Node(u, v, amt, 0, i));
        }

        seen = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (graph.get(i).size() > 0) {
                dfs(i);
            }
        }

        return count;
    }

    public static void dfs(int u) {
        
    }
}
