package Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TheyAreEverywhere {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        String s = in.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 0);
        }

        int total = map.size();
        map.clear();

        int res = n + 1;
        for (int i = 0, j = 0; j < n; j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() == total) {
                res = Math.min(res, j - i + 1);
                char ith = s.charAt(i);
                if (map.get(ith) == 1) {
                    map.remove(ith);
                } else {
                    map.put(ith, map.get(ith) - 1);
                }
                i++;
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
