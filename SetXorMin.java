import java.io.*;
import java.util.*;

public class SetXorMin {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static class Trie {
    private static class Node {
        Node left, right;
        int cnt;
    }

    public static Node root = new Node();

    public static void insert(int num, int x) {
        Node curr = root;
        for (int bitIndex = 29; bitIndex >= 0; bitIndex--) {
            curr.cnt += x;
            int bit = (num >> bitIndex) & 1;
            if (bit == 0) {
                if (curr.left == null) curr.left = new Node();
                curr = curr.left;
            } else {
                if (curr.right == null) curr.right = new Node();
                curr = curr.right;
            }
        }
        curr.cnt += x;
    }

    public static int query(int num) {
        Node curr = root;
        int ans = 0;
        for (int bitIndex = 29; bitIndex >= 0; bitIndex--) {
            int bit = (num >> bitIndex) & 1;
            if ((bit == 0 && curr.left != null && curr.left.cnt > 0) ||
                (bit == 1 && curr.right != null && curr.right.cnt > 0)) {
                curr = (bit == 0) ? curr.left : curr.right;
            } else {
                curr = (bit == 0) ? curr.right : curr.left;
                ans |= (1 << bitIndex);
            }
        }
        return ans;
    }
}

    static void solve() {
        int n = in.nextInt();

        HashSet<Integer> set = new HashSet<>();
        Trie t = new Trie();

        for(int i=0; i<n; i++) {
        	int type = in.nextInt();
        	int x = in.nextInt();

        	if(type == 0) {
        		set.add(x);
        		t.insert(x, 1);
        	} else if(type == 1) {
        		if(set.contains(x)) {
        			t.insert(x, -1);
        			set.remove(x);
        		}
	        	} else {
        		out.println(t.query(x));
        	}
        }
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}