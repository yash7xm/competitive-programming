package Graph;
import java.util.*;
import java.io.*;

public class DeBruijnSequence {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static String generate(int alphabetSize, int length) {
        StringBuilder seq = new StringBuilder();
        char[] current = new char[alphabetSize * length];
        Arrays.fill(current, '0');
        dfs(current, seq, alphabetSize, length, 1, 1);

        for (int i = 0; i < length - 1; i++) {
            seq.append(seq.charAt(i));
        }
        return seq.toString();
    }

    static void dfs(char[] curr, StringBuilder seq, int alphabetSize, int length, int t, int p) {
        if (t > length) {
            if (length % p == 0) {
                for (int j = 1; j <= p; j++) {
                    seq.append(curr[j]);
                }
            }
        } else {
            curr[t] = curr[t - p];
            dfs(curr, seq, alphabetSize, length, t + 1, p);
            for (int j = curr[t - p] + 1; j < '0' + alphabetSize; j++) {
                curr[t] = (char) j;
                dfs(curr, seq, alphabetSize, length, t + 1, t);
            }
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        String res = generate(2, n);
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
