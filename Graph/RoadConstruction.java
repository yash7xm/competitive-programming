package Graph;
import java.util.*;
import java.io.*;

public class RoadConstruction {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int parent[], rank[], len[];
    static int comp, max;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    static void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
                len[lx] += len[ly];
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
                len[ly] += len[lx];
            } else {
                parent[lx] = ly;
                rank[ly]++;
                len[ly] += len[lx];
            }
            comp--;
            max = Math.max(max, Math.max(len[lx], len[ly]));
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        len = new int[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
            len[i] = 1;
        }
        int m = in.nextInt();

        comp = n;
        max = 1;
        for (int i = 1; i <= m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            union(u, v);

            out.println(comp + " " + max);
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
