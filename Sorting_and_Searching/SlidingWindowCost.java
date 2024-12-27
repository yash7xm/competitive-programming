package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SlidingWindowCost {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static long lsum = 0, rsum = 0;

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        long[] res = new long[n - k + 1];

        for (int i = 0; i < k; i++) {
            if (right.size() > 0 && arr[i] >= right.peek()) {
                rsum += arr[i];
                right.add(arr[i]);
            } else {
                lsum += arr[i];
                left.add(arr[i]);
            }
            order(left, right);
        }
        int median = left.peek();

        long ans = 0;
        if (k % 2 == 0) {
            ans = (rsum) - (lsum);
        } else {
            ans = (rsum) - (lsum - median);
        }

        res[0] = ans;

        int idx = 1;
        for (int i = 0, j = k; j < n; j++, idx++, i++) {
            if (arr[i] <= left.peek()) {
                lsum -= arr[i];
                left.remove(arr[i]);
            } else {
                rsum -= arr[i];
                right.remove(arr[i]);
            }
            order(left, right);
            if (right.size() > 0 && arr[j] >= right.peek()) {
                rsum += arr[j];
                right.add(arr[j]);
            } else {
                lsum += arr[j];
                left.add(arr[j]);
            }
            order(left, right);

            median = left.peek();

            ans = 0;
            if (k % 2 == 0) {
                ans = (rsum) - (lsum);
            } else {
                ans = (rsum) - (lsum - median);
            }

            res[idx] = ans;
        }

        for (int i = 0; i < res.length; i++) {
            out.print(res[i] + " ");
        }
        out.println();

        out.flush();
    }

    private static void order(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() > right.size() + 1) {
            rsum += left.peek();
            lsum -= left.peek();
            right.add(left.poll());
        } else if (right.size() > left.size()) {
            rsum -= right.peek();
            lsum += right.peek();
            left.add(right.poll());
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
