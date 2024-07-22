package Graph;

import java.util.*;
import java.io.*;

public class RoadReparation {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Pair implements Comparable<Pair> {
        int nbr;
        long cost;

        Pair(int nbr, long cost) {
            this.nbr = nbr;
            this.cost = cost;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static ArrayList<ArrayList<Pair>> graph;

    public static void main(String[] args) {
        int n = in.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int c = in.nextInt();

            graph.get(u).add(new Pair(v, c));
            graph.get(v).add(new Pair(u, c));
        }

        long ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));
        boolean[] vis = new boolean[n + 1];

        while (pq.size() > 0) {
            Pair rem = pq.poll();
            if (vis[rem.nbr])
                continue;

            vis[rem.nbr] = true;

            ans += rem.cost;

            vis[rem.nbr] = true;

            for (Pair e : graph.get(rem.nbr)) {
                if (!vis[e.nbr]) {
                    pq.add(new Pair(e.nbr, e.cost));
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (vis[i] == false) {
                flag = true;
                break;
            }
        }

        if (!flag)
            out.println(ans);
        else {
            out.println("IMPOSSIBLE");
        }

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
