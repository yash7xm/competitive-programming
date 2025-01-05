package Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MergingArrays {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] brr = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = in.nextInt();
        }

        int[] res = new int[n + m];
        int i = 0, j = 0, idx = 0;
        while (i < n && j < m) {
            if (arr[i] < brr[j]) {
                res[idx] = arr[i];
                i++;
            } else {
                res[idx] = brr[j];
                j++;
            }
            idx++;
        }

        while (i < n) {
            res[idx] = arr[i];
            i++;
            idx++;
        }

        while (j < m) {
            res[idx] = brr[j];
            j++;
            idx++;
        }

        for (i = 0; i < n + m; i++) {
            out.print(res[i] + " ");
        }
        out.println();

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
