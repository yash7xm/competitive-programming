package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestaurantCustomers {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[][] arr = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            arr[2 * i][0] = start;
            arr[2 * i][1] = 1;
            arr[2 * i + 1][0] = end;
            arr[2 * i + 1][1] = -1;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int curr = 0;
        int res = 0;
        for (int i = 0; i < 2 * n; i++) {
            curr += arr[i][1];
            res = Math.max(res, curr);
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
    }
}
