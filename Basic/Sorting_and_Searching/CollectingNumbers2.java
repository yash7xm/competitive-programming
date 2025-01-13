package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CollectingNumbers2 {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            pos[arr[i]] = i;
        }

        int rounds = 1;
        for (int i = 2; i <= n; i++) {
            if (pos[i] < pos[i - 1]) {
                rounds++;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;

            // Identify affected elements
            HashSet<Integer> affected = new HashSet<>();
            affected.add(arr[a]);
            affected.add(arr[b]);
            if (arr[a] > 1)
                affected.add(arr[a] - 1);
            if (arr[a] < n)
                affected.add(arr[a] + 1);
            if (arr[b] > 1)
                affected.add(arr[b] - 1);
            if (arr[b] < n)
                affected.add(arr[b] + 1);

            // Remove transitions affected by these elements
            for (int x : affected) {
                if (x > 1 && pos[x] < pos[x - 1])
                    rounds--;
            }

            // Perform the swap
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;

            pos[arr[a]] = a;
            pos[arr[b]] = b;

            // Add transitions back
            for (int x : affected) {
                if (x > 1 && pos[x] < pos[x - 1])
                    rounds++;
            }

            // Output the number of rounds
            out.println(rounds);
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
