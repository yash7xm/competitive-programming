package DP;

import java.util.*;
import java.io.*;

public class LongestPath {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static List<List<Integer>> graph;
    static List<Integer> topsort;

    static void topologicalSort(int n) {
        int[] indeg = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int v : graph.get(i)) {
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
                    q.addLast(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            graph.get(u).add(v);
        }

        topsort = new ArrayList<>();
        topologicalSort(n);

        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(topsort.get(n - 1), 0);

        int res = 0;

        for (int i = n - 2; i >= 0; i--) {
            int u = topsort.get(i);
            dp.put(u, 0);
            for (int v : graph.get(u)) {
                dp.put(u, Math.max(dp.get(u), dp.get(v) + 1));
            }
            res = Math.max(res, dp.get(u));
        }

        out.println(res);

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
