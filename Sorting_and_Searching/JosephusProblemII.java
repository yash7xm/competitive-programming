package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JosephusProblemII {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        int root = (int) Math.sqrt(n);
        int row = 0, col = 0, count = 0;

        ArrayList<Integer> vec = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (count > root) {
                count = 0;
                arr.add(new ArrayList<>(vec));
                vec.clear();
            }
            vec.add(i);
            count++;
        }
        
        if (!vec.isEmpty()) {
            arr.add(new ArrayList<>(vec));
        }

        for (int i = 0; i < n; i++) {
            int j = k % (n - i);
            while (j > 0) {
                if (col + j < arr.get(row).size()) {
                    col += j;
                    j = 0;
                } else {
                    j -= arr.get(row).size() - col;
                    col = 0;
                    row++;
                }

                if (row >= arr.size()) {
                    row = 0;
                }
            }

            while (arr.get(row).size() <= col) {
                col = 0;
                row++;
                if (row >= arr.size()) {
                    row = 0;
                }
            }

            out.printf("%d ", arr.get(row).get(col));
            if (i != n - 1) {
                arr.get(row).remove(col);
                while (arr.get(row).size() <= col) {
                    col = 0;
                    row++;
                    if (row >= arr.size()) {
                        row = 0;
                    }
                }
            }
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
