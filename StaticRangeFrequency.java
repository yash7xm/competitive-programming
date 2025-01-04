import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StaticRangeFrequency {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            map.put(a, map.getOrDefault(a, new ArrayList<>()));
            map.get(a).add(i);
        }

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int x = in.nextInt();

            ArrayList<Integer> v = map.getOrDefault(x, new ArrayList<>());

            int lower = Collections.binarySearch(v, l);
            int upper = Collections.binarySearch(v, r);

            if (lower < 0)
                lower = -lower - 1;
            if (upper < 0)
                upper = -upper - 1;

            int ans = upper - lower;

            out.println(ans);
        }

        out.flush();
    }

    static int lowerBound(ArrayList<Integer> list, int tar) {
        int lo = 0, hi = list.size() - 1;
        int ans = lo;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= tar) {
                lo = mid + 1;
                ans = mid;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
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
    }
}
