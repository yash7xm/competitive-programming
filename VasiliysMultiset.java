import java.io.*;
import java.util.*;

class VasiliysMultiset {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Trie {
        private static class Node {
            Node left, right;
            int cnt;
        }

        public static Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(int val, int x) {
            int bitIndex = 30;
            Node curr = root;
            while (bitIndex >= 0) {
                int mask = 1 << bitIndex;
                int bit = (mask & val) > 0 ? 1 : 0;
                curr.cnt += x;
                if (bit == 0) {
                    if (curr.left == null) {
                        curr.left = new Node();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }
                bitIndex--;
            }
            curr.cnt += x;
        }

        public int query(int find) {
            int bitIndex = 30;
            Node curr = root;
            int ans = 0;

            while (bitIndex >= 0) {
                int mask = 1 << bitIndex;
                int bit = (find & mask) > 0 ? 1 : 0;

                if (bit == 0) {
                    if (curr.right != null && curr.right.cnt > 0) {
                        ans |= mask;
                        curr = curr.right;
                    } else if (curr.left != null && curr.left.cnt > 0) {
                        curr = curr.left;
                    }
                } else {
                    if (curr.left != null && curr.left.cnt > 0) {
                        ans |= mask;
                        curr = curr.left;
                    } else if (curr.right != null && curr.right.cnt > 0) {
                        curr = curr.right;
                    }
                }
                bitIndex--;
            }

            return ans;
        }
    }

    static void solve() {
        int n = in.nextInt();
        Trie trie = new Trie();
        trie.insert(0, 1);

        for (int i = 0; i < n; i++) {
            String op = in.next();
            int x = in.nextInt();
            if (op.equals("+")) {
                trie.insert(x, 1);
            } else if (op.equals("-")) {
                trie.insert(x, -1);
            } else {
                out.println(trie.query(x));
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
