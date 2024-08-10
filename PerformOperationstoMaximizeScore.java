import java.io.*;
import java.util.*;

public class PerformOperationstoMaximizeScore {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            System.out.println(maxScore(n, k, a, b));
        }
    }

    public static int maxScore(int n, int k, int[] a, int[] b) {
        int low = Arrays.stream(a).min().getAsInt();
        int high = Arrays.stream(a).max().getAsInt() + k;

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canAchieveScore(n, k, a, b, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static boolean canAchieveScore(int n, int k, int[] a, int[] b, int targetScore) {
        int requiredOperations = 0;
        
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                int[] ci = new int[n - 1];
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        ci[index++] = a[j];
                    }
                }
                Arrays.sort(ci);
                int medianValue = ci[(n - 2) / 2];
                
                int neededIncrease = targetScore - (a[i] + medianValue);
                if (neededIncrease > 0) {
                    requiredOperations += neededIncrease;
                    if (requiredOperations > k) {
                        return false;
                    }
                }
            }
        }
        
        return requiredOperations <= k;
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
