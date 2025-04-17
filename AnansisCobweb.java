import java.io.*;
import java.util.*;

public class AnansisCobweb {
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = in.nextInt() - 1;
            edges[i][1] = in.nextInt() - 1;
        }

        int q = in.nextInt();
        int[] toRemove = new int[q];
        Set<Integer> removedSet = new HashSet<>();

        for (int i = 0; i < q; i++) {
            toRemove[i] = in.nextInt() - 1;
            removedSet.add(toRemove[i]);
        }

        // Initialize DSU
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int components = n;

        for (int i = 0; i < m; i++) {
            if (!removedSet.contains(i)) {
                if (union(edges[i][0], edges[i][1])) {
                    components--;
                }
            }
        }

        int[] result = new int[q];

        for (int i = q - 1; i >= 0; i--) {
            result[i] = components;
            int idx = toRemove[i];
            if (union(edges[idx][0], edges[idx][1])) {
                components--;
            }
        }

        for (int res : result) {
            out.print(res + " ");
        }

        out.close();
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
            rank[pb]++;
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
