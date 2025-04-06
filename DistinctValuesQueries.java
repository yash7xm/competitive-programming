import java.io.*;
import java.util.*;

public class DistinctValuesQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Query implements Comparable<Query> {
        int l, r, idx, block;

        Query(int l, int r, int idx, int blockSize) {
            this.l = l;
            this.r = r;
            this.idx = idx;
            this.block = l / blockSize;
        }

        public int compareTo(Query other) {
            if (this.block != other.block)
                return Integer.compare(this.block, other.block);
            return (this.block % 2 == 0) ?
                Integer.compare(this.r, other.r) :
                Integer.compare(other.r, this.r);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        int[] answer = new int[q];

        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        int blockSize = (int)Math.sqrt(n) + 1;

        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            queries[i] = new Query(l, r, i, blockSize);
        }

        Arrays.sort(queries);

        HashMap<Integer, Integer> freq = new HashMap<>();
        int currL = 0, currR = -1, distinct = 0;

        for (Query qu : queries) {
            while (currL > qu.l) {
                currL--;
                freq.put(arr[currL], freq.getOrDefault(arr[currL], 0) + 1);
                if (freq.get(arr[currL]) == 1) distinct++;
            }

            while (currR < qu.r) {
                currR++;
                freq.put(arr[currR], freq.getOrDefault(arr[currR], 0) + 1);
                if (freq.get(arr[currR]) == 1) distinct++;
            }

            while (currL < qu.l) {
                freq.put(arr[currL], freq.get(arr[currL]) - 1);
                if (freq.get(arr[currL]) == 0) distinct--;
                currL++;
            }

            while (currR > qu.r) {
                freq.put(arr[currR], freq.get(arr[currR]) - 1);
                if (freq.get(arr[currR]) == 0) distinct--;
                currR--;
            }

            answer[qu.idx] = distinct;
        }

        for (int a : answer) out.println(a);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
