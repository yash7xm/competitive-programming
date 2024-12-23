import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PreparingfortheExam {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextInt();
            }

            HashSet<Integer> ques = new HashSet<>();
            for (int i = 0; i < k; i++) {
                ques.add(in.nextInt());
            }

            StringBuilder sb = new StringBuilder();
            if (ques.size() == n) {
                for (int i = 0; i < m; i++) {
                    sb.append("1");
                }
            } else if (ques.size() <= n - 2) {
                for (int i = 0; i < m; i++) {
                    sb.append("0");
                }
            } else {
                for (int i = 0; i < m; i++) {
                    if (ques.contains(arr[i])) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }
            }

            out.println(sb.toString());
            out.flush();
        }
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
