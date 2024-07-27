package DP;

import java.util.*;
import java.io.*;

public class Vacation {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        int[] crr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            brr[i] = in.nextInt();
            crr[i] = in.nextInt();
        }

        int a = arr[0], b = brr[0], c = crr[0];

        for (int i = 1; i < n; i++) {
            int na = Math.max(b, c) + arr[i];
            int nb = Math.max(a, c) + brr[i];
            int nc = Math.max(a, b) + crr[i];

            a = na;
            b = nb;
            c = nc;
        }

        out.println(Math.max(a, Math.max(b, c)));

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
