package Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CellularNetworkTwoPointers {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] cities = new int[n];
        int[] towers = new int[m];

        for (int i = 0; i < n; i++) {
            cities[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            towers[i] = in.nextInt();
        }

        int i = 0, j = 0;
        long maxDistance = 0;

        while (i < n) {
            while (j < m - 1 && Math.abs(towers[j + 1] - cities[i]) <= Math.abs(towers[j] - cities[i])) {
                j++;
            }

            long closestDistance = Math.abs(towers[j] - cities[i]);

            maxDistance = Math.max(maxDistance, closestDistance);

            i++;
        }

        out.println(maxDistance);
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
