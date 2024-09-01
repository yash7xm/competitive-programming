package Tree;

import java.util.*;
import java.io.*;

public class Subordinates {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static List<List<Integer>> tree;
    static int[] res;

    public static void main(String[] args) {
        int n = in.nextInt();
        tree = new ArrayList<>();
        res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int u = in.nextInt();
            tree.get(u).add(i);
        }

        dfs(1);

        for (int i = 1; i <= n; i++) {
            out.print(res[i] + " ");
        }
        out.flush();
    }

    private static int dfs(int u) {
        int sum = 0;
        for (int child : tree.get(u)) {
            sum += dfs(child) + 1;
        }
        res[u] = sum;
        return sum;
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
    }
}
