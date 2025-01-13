package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NestedRangesCheck {

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

    public static void main(String[] args) {
        int n = in.nextInt();
        Range[] arr = new Range[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Range(in.nextInt(), in.nextInt(), i);
        }

        Arrays.sort(arr);

        int[] contains = new int[n];
        int minEnd = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i].end >= minEnd) {
                contains[arr[i].index] = 1;
            }

            minEnd = Math.min(minEnd, arr[i].end);
        }

        int[] contained = new int[n];
        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i].end <= maxEnd) {
                contained[arr[i].index] = 1;
            }

            maxEnd = Math.max(maxEnd, arr[i].end);
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