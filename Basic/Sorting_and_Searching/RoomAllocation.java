package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RoomAllocation {

    public static class Node implements Comparable<Node> {
        int time, index;
        boolean arrival;

        public Node(int time, int index, boolean arrival) {
            this.time = time;
            this.index = index;
            this.arrival = arrival;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time == o.time) {
                return Boolean.compare(o.arrival, this.arrival);
            }
            return Integer.compare(this.time, o.time);
        }
    }

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        Node[] arr = new Node[2 * n];
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            arr[2 * i] = new Node(l, i, true);
            arr[2 * i + 1] = new Node(r, i, false);
        }

        Arrays.sort(arr);

        int maxRoom = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Integer.MAX_VALUE);

        int[] res = new int[n];
        for (int i = 0; i < arr.length; i++) {
            Node node = arr[i];
            if (node.arrival) {
                res[node.index] = Math.min(maxRoom, pq.peek());
                if (pq.peek() < maxRoom) {
                    pq.poll();
                } else {
                    maxRoom++;
                }
            } else {
                pq.add(res[node.index]);
            }
        }

        out.println(maxRoom - 1);
        for (int i = 0; i < n; i++) {
            out.printf("%d ", res[i]);
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
