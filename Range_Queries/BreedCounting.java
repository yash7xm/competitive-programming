package Range_Queries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BreedCounting {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[][] quer = new int[q][2];
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            quer[i][0] = l - 1;
            quer[i][1] = r - 1;
        }

        int[][] prefix = new int[n][3];
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (i == 0) {
                prefix[i][x - 1]++;
            } else {
                prefix[i][0] = prefix[i - 1][0];
                prefix[i][1] = prefix[i - 1][1];
                prefix[i][2] = prefix[i - 1][2];
                prefix[i][x - 1]++;
            }
        }

        for (int i = 0; i < q; i++) {
            int l = quer[i][0];
            int r = quer[i][1];

            int ones = l > 0 ? prefix[r][0] - prefix[l - 1][0] : prefix[r][0];
            int twos = l > 0 ? prefix[r][1] - prefix[l - 1][1] : prefix[r][1];
            int threes = l > 0 ? prefix[r][2] - prefix[l - 1][2] : prefix[r][2];

            out.println(ones + " " + twos + " " + threes);
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
    }
}
