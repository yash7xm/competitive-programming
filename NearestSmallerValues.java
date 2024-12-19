import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class NearestSmallerValues {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[n];
        res[0] = 0;
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            res[i] = st.size() > 0 && arr[i] > arr[st.peek()] ? st.peek() + 1 : 0;
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
        out.println("");
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
