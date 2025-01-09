import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TwoSets {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        long total = (1L * n * (1L * n + 1)) / 2;
        if ((total & 1) != 0) {
            out.println("NO");
        } else {
            out.println("YES");

            List<Integer> set1 = new ArrayList<>();
            List<Integer> set2 = new ArrayList<>();

            boolean[] vis = new boolean[n + 1];

            long sum1 = 0;
            int max = n;
            while (sum1 < total / 2) {
                long rem = total / 2 - sum1;
                if (rem > max) {
                    sum1 += max;
                    set1.add(max);
                    vis[max] = true;
                    max--;
                } else {
                    sum1 = total / 2;
                    set1.add((int) rem);
                    vis[(int) rem] = true;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    set2.add(i);
                }
            }

            out.println(set1.size());
            for (int x : set1) {
                out.print(x + " ");
            }
            out.println();
            out.println(set2.size());
            for (int x : set2) {
                out.print(x + " ");
            }
            out.println();
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
    }
}
