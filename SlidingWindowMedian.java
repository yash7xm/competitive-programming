import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SlidingWindowMedian {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            if (right.size() > 0 && arr[i] >= right.peek()) {
                right.add(arr[i]);
            } else {
                left.add(arr[i]);
            }
            order(left, right);
        }
        res[0] = left.peek();

        int idx = 1;
        for (int i = 0, j = k; j < n; j++, idx++, i++) {
            if (left.contains(arr[i])) {
                left.remove(arr[i]);
            } else {
                right.remove(arr[i]);
            }
            order(left, right);
            if (right.size() > 0 && arr[j] >= right.peek()) {
                right.add(arr[j]);
            } else {
                left.add(arr[j]);
            }
            order(left, right);

            res[idx] = left.peek();
        }

        for (int i = 0; i < res.length; i++) {
            out.print(res[i] + " ");
        }
        out.println();

        out.flush();
    }

    private static void order(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size()) {
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
