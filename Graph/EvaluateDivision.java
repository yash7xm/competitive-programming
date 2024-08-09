package Graph;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        // https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=top-interview-150

        // Simple approach create a directed graph where vertexes are num and denom
        // and num -> denom edge weight is values[i]
        // denom -> num edge weight is 1/values[i]
        // then simply using dijastra find shortes path between l and r i.e queries
    }

    public static class Node implements Comparable<Node> {
        String vtx;
        double val;

        Node(String vtx, double val) {
            this.vtx = vtx;
            this.val = val;
        }

        public int compareTo(Node o) {
            return Double.compare(this.val, o.val);
        }
    }

    static Map<String, List<Node>> graph;
    static double ans;
    static Map<String, Double> path;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            List<Node> nbrs = new ArrayList<>();
            if (!graph.containsKey(u)) {
                nbrs.add(new Node(v, values[i]));
                graph.put(u, nbrs);
            } else {
                nbrs = graph.get(u);
                nbrs.add(new Node(v, values[i]));
                graph.put(u, nbrs);
            }

            nbrs = new ArrayList<>();
            if (!graph.containsKey(v)) {
                nbrs.add(new Node(u, (double) 1 / values[i]));
                graph.put(v, nbrs);
            } else {
                nbrs = graph.get(v);
                nbrs.add(new Node(u, (double) 1 / values[i]));
                graph.put(v, nbrs);
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String l = queries.get(i).get(0);
            String r = queries.get(i).get(1);
            ans = 1;
            path = new HashMap<>();
            for (String str : graph.keySet()) {
                path.put(str, Double.MAX_VALUE);
            }
            if (path.containsKey(l) && path.containsKey(r)) {
                dfs(new Node(l, 1.0));
                if (path.get(r) == Double.MAX_VALUE) {
                    ans = (double) -1;
                } else {
                    ans = path.get(r);
                }
            } else {
                ans = (double) -1;
            }

            res[i] = ans;
        }

        return res;
    }

    private static void dfs(Node u) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(u);

        while (pq.size() > 0) {
            Node rem = pq.poll();

            for (Node nbr : graph.get(rem.vtx)) {
                double newVal = rem.val * nbr.val;
                if (path.get(nbr.vtx) > newVal) {
                    path.put(nbr.vtx, newVal);
                    pq.add(new Node(nbr.vtx, newVal));
                }
            }
        }
    }
}
