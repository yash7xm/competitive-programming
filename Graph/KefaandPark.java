package Graph;
import java.util.*;
import java.io.*;

public class KefaandPark {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] cats;
    static List<List<Integer>> graph;
    static boolean vis[];
    static int ans = 0;

    public static class Pair {
        int vtx;
        int cat;

        Pair(int vtx, int cat) {
            this.vtx = vtx;
            this.cat = cat;
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        cats = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cats[i] = in.nextInt();
        }
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        LinkedList<Pair> q = new LinkedList<>();
        if (cats[1] == 1) {
            q.addLast(new Pair(1, 1));
        } else {
            q.addLast(new Pair(1, 0));
        }
        vis = new boolean[n + 1];

        while (q.size() > 0) {
            Pair rem = q.removeFirst();

            if (vis[rem.vtx])
                continue;
            vis[rem.vtx] = true;

            boolean isLeaf = true;
            for (int v : graph.get(rem.vtx)) {
                if (!vis[v]) {
                    isLeaf = false;
                    break;
                }
            }
            if (isLeaf) {
                ans++;
                continue;
            }

            for (int v : graph.get(rem.vtx)) {
                if (!vis[v]) {
                    int currCats = rem.cat;
                    if (cats[v] == 1) {
                        currCats++;
                    } else {
                        currCats = 0;
                    }

                    if (currCats <= m) {
                        q.addLast(new Pair(v, currCats));
                    }
                }
            }
        }

        out.println(ans);

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
