import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] applicants = new int[n];
        for (int i = 0; i < n; i++) {
            applicants[i] = in.nextInt();
        }

        int[] apartments = new int[m];
        for (int i = 0; i < m; i++) {
            apartments[i] = in.nextInt();
        }

        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i = 0, j = 0, res = 0;

        while (i < n && j < m) {
            if (apartments[j] < applicants[i] - k) {
                j++;
            } else if (apartments[j] > applicants[i] + k) {
                i++;
            } else {
                res++;
                i++;
                j++;
            }
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
