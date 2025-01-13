package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubarrayDistinctValues {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long cnt = 0;
        int i = -1, j = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < n - 1) {
                f1 = true;
                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if (map.size() <= k) {
                    cnt += i - j;
                } else {
                    break;
                }
            }

            if (i == n - 1 && map.size() <= k)
                break;

            while (j < i) {
                f2 = true;
                j++;
                if (map.get(arr[j]) == 1) {
                    map.remove(arr[j]);
                } else {
                    map.put(arr[j], map.get(arr[j]) - 1);
                }

                if (map.size() <= k) {
                    cnt += i - j;
                    break;
                }
            }

            if (!f1 && !f2)
                break;
        }

        out.println(cnt);
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
