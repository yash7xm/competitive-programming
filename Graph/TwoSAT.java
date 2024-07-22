package Graph;

import java.util.*;

public class TwoSAT {

    private int n;
    private List<List<Integer>> adj;
    private List<List<Integer>> adjRev;
    private boolean[] visited;
    private Stack<Integer> stack;
    private int[] component;
    private boolean[] assignment;

    public TwoSAT(int n) {
        this.n = n;
        adj = new ArrayList<>();
        adjRev = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }
        visited = new boolean[2 * n];
        stack = new Stack<>();
        component = new int[2 * n];
        assignment = new boolean[2 * n];
    }

    private int negate(int x) {
        return x < n ? x + n : x - n;
    }

    public void addClause(int x, int y) {
        adj.get(negate(x)).add(y);
        adj.get(negate(y)).add(x);
        adjRev.get(y).add(negate(x));
        adjRev.get(x).add(negate(y));
    }

    private void dfs1(int v) {
        visited[v] = true;
        for (int u : adj.get(v)) {
            if (!visited[u]) {
                dfs1(u);
            }
        }
        stack.push(v);
    }

    private void dfs2(int v, int comp) {
        component[v] = comp;
        for (int u : adjRev.get(v)) {
            if (component[u] == -1) {
                dfs2(u, comp);
            }
        }
    }

    public boolean solve() {
        Arrays.fill(visited, false);
        for (int i = 0; i < 2 * n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        Arrays.fill(component, -1);
        int comp = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (component[v] == -1) {
                dfs2(v, comp++);
            }
        }

        for (int i = 0; i < n; i++) {
            if (component[i] == component[negate(i)]) {
                return false;
            }

            assignment[i] = component[i] > component[negate(i)];
        }
        return true;
    }

    public boolean[] getAssignment() {
        return assignment;
    }

    public static void main(String[] args) {
        // Example: (A ∨ B) ∧ (¬A ∨ ¬B)
        int n = 2;
        TwoSAT solver = new TwoSAT(n);

        // Variables A and B are represented by 0 and 1 respectively
        // ¬A is represented by 2 and ¬B by 3
        solver.addClause(0, 1); // (A ∨ B)
        solver.addClause(2, 3); // (¬A ∨ ¬B)

        if (solver.solve()) {
            boolean[] assignment = solver.getAssignment();
            for (int i = 0; i < n; i++) {
                System.out.println("Variable " + i + " is " + (assignment[i] ? "True" : "False"));
            }
        } else {
            System.out.println("No solution exists.");
        }
    }
}
