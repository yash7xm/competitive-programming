package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class TrafficLights {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int x = in.nextInt();
        int n = in.nextInt();

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(x);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(x, 1);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = set.floor(pos[i]);
            int right = set.ceiling(pos[i]);

            int oldSeg = right - left;
            int leftSeg = pos[i] - left;
            int rightSeg = right - pos[i];

            if (map.get(oldSeg) == 1) {
                map.remove(oldSeg);
            } else {
                map.put(oldSeg, map.get(oldSeg) - 1);
            }

            set.add(pos[i]);
            map.put(leftSeg, map.getOrDefault(leftSeg, 0) + 1);
            map.put(rightSeg, map.getOrDefault(rightSeg, 0) + 1);

            res.add(map.lastKey());
        }

        for (int r : res) {
            out.print(r + " ");
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
