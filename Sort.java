import java.util.*;
import java.io.*;

public class Sort {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int q = in.nextInt();

            String a = in.nextLine();
            String b = in.nextLine();

            int[][] arr = new int[n][26];
            int[][] brr = new int[n][26];

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    int j = (int) (a.charAt(i) - 'a');
                    arr[i][j]++;
                } else {
                    int j = (int) (a.charAt(i) - 'a');
                    arr[i][j]++;
                    for (int k = 0; k < 26; k++) {
                        arr[i][k] += arr[i - 1][k];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    int j = (int) (b.charAt(i) - 'a');
                    brr[i][j]++;
                } else {
                    int j = (int) (b.charAt(i) - 'a');
                    brr[i][j]++;
                    for (int k = 0; k < 26; k++) {
                        brr[i][k] += brr[i - 1][k];
                    }
                }
            }

            for (int i = 0; i < q; i++) {
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;

                int[] arange = new int[26];
                if (l == 0) {
                    arange = arr[r];
                } else {
                    for (int j = 0; j < 26; j++) {
                        arange[j] = arr[r][j] - arr[l - 1][j];
                    }
                }

                int[] brange = new int[26];
                if (l == 0) {
                    brange = brr[r];
                } else {
                    for (int j = 0; j < 26; j++) {
                        brange[j] = brr[r][j] - brr[l - 1][j];
                    }
                }

                int cnt = 0;

                for (int j = 0; j < 26; j++) {
                    cnt += Math.abs(arange[j] - brange[j]);
                }

                out.println(cnt / 2);
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
