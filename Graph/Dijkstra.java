package Graph;
import java.util.*;
import java.io.*;

public class Dijkstra {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static class Pair implements Comparable<Pair> {
        int vtx;
        long len;

        Pair(int vtx, long len) {
            this.vtx = vtx;
            this.len = len;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.len, o.len);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        int[] parent = new int[n + 1];
        long[] dis = new long[n + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(dis, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));

        while (pq.size() > 0) {
            Pair rem = pq.poll();

            for (Pair nbr : graph.get(rem.vtx)) {
                long newDis = nbr.len + rem.len;
                if (newDis < dis[nbr.vtx]) {
                    dis[nbr.vtx] = newDis;
                    pq.add(new Pair(nbr.vtx, nbr.len + rem.len));
                    parent[nbr.vtx] = rem.vtx;
                }
            }
        }

        if (parent[n] == -1) {
            out.println(-1);
        } else {
            List<Integer> res = new ArrayList<>();
            for (int i = n; i != 1; i = parent[i]) {
                res.add(i);
            }
            res.add(1);

            for (int i = res.size() - 1; i >= 0; i--) {
                out.print(res.get(i) + " ");
            }
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