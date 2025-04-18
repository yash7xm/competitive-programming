import java.io.*;
import java.util.*;

public class CuttingAGraph {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int[] parent, rank;

    public static int find(int x) {
        if(parent[x] == x) return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    public static void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if(lx != ly) {
            if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if(rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }

    public static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        Map<String, Boolean> toBeCut = new HashMap<>();
        List<int[]> edges = new ArrayList<>();
        List<String[]> operations = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edges.add(new int[]{u, v});
        }

        for (int i = 0; i < k; i++) {
            String op = in.next();
            int u = in.nextInt();
            int v = in.nextInt();
            operations.add(new String[]{op, String.valueOf(u), String.valueOf(v)});

            if (op.equals("cut")) {
                String key = Math.min(u, v) + "-" + Math.max(u, v);
                toBeCut.put(key, true);
            }
        }

        parent = new int[n + 1];
        rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        } 

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            String key = Math.min(u, v) + "-" + Math.max(u, v);
            if (!toBeCut.containsKey(key)) {
                union(u, v);
            }
        }

        List<String> res = new ArrayList<>();

        for (int i = k - 1; i >= 0; i--) {
            String[] op = operations.get(i);
            String type = op[0];
            int u = Integer.parseInt(op[1]);
            int v = Integer.parseInt(op[2]);

            if (type.equals("ask")) {
                if (find(u) == find(v)) {
                    res.add("YES");
                } else {
                    res.add("NO");
                }
            } else { // cut becomes union
                union(u, v);
            }
        }

        Collections.reverse(res);
        for (String ans : res) {
            out.println(ans);
        }
    }

    public static void main(String[] args) {
        solve();
        out.close();
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
