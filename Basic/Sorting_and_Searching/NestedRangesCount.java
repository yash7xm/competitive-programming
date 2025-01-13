package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NestedRangesCount {

    public static class Range implements Comparable<Range> {
        int start, end, index;

        public Range(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Range o) {
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(o.end, this.end);
        }
    }

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = in.nextInt();
        Range[] arr = new Range[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = new Range(in.nextInt(), in.nextInt(), i);
            list.add(arr[i].end);
        }

        Arrays.sort(arr);

        int size = compress(list);
        int[] farr = new int[size];
        int[] contains = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = map.get(arr[i].end);
            contains[arr[i].index] = query(idx, farr);
            update(idx, farr);
        }

        int[] contained = new int[n];
        Arrays.fill(farr, 0);
        for (int i = 0; i < n; i++) {
            int idx = map.get(arr[i].end);
            contained[arr[i].index] = (query(farr.length - 1, farr) - query(idx - 1, farr));
            update(idx, farr);
        }

        for (int i = 0; i < n; i++) {
            out.printf("%d ", contains[i]);
        }
        out.println();
        for (int i = 0; i < n; i++) {
            out.printf("%d ", contained[i]);
        }

        out.flush();
    }

    public static int compress(ArrayList<Integer> list) {
        Collections.sort(list);
        int idx = 1;
        for (int val : list) {
            if (!map.containsKey(val)) {
                map.put(val, idx++);
            }
        }

        return idx;
    }

    public static int query(int idx, int[] farr) {
        int cnt = 0;
        while (idx > 0) {
            cnt += farr[idx];
            idx -= idx & (-idx);
        }

        return cnt;
    }

    public static void update(int idx, int[] farr) {
        while (idx < farr.length) {
            farr[idx]++;
            idx += idx & (-idx);
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
