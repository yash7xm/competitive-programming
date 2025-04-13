import java.io.*;
import java.util.*;

public class OrderOfDigits {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Trie {
        static class Node {
            Node[] children = new Node[10];
            int count = 0;
        }

        Node root = new Node();

        public void insert(String num) {
            Node curr = root;
            for (char ch : num.toCharArray()) {
                int digit = ch - '0';
                if (curr.children[digit] == null)
                    curr.children[digit] = new Node();
                curr = curr.children[digit];
            }
            curr.count++;
        }

        long countLessThan(Node node, String x, int pos, int[] invPriority) {
            if (node == null) return 0;
            if (pos == x.length()) return 0;

            int digitX = x.charAt(pos) - '0';
            long count = 0;

            for (int d = 0; d < 10; d++) {
                if (invPriority[d] < invPriority[digitX]) {
                    if (node.children[d] != null)
                        count += countAll(node.children[d]);
                }
            }

            if (node.children[digitX] != null)
                count += countLessThan(node.children[digitX], x, pos + 1, invPriority);

            return count;
        }

        long countAll(Node node) {
            if (node == null) return 0;
            long res = node.count;
            for (Node child : node.children)
                res += countAll(child);
            return res;
        }
    }

    public static void solve() {
        int n = in.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(in.next());
        }

        int q = in.nextInt();
        for (int qi = 0; qi < q; qi++) {
            int[] customOrder = new int[10];
            int[] invOrder = new int[10];
            for (int i = 0; i < 10; i++) {
                customOrder[i] = in.nextInt();
                invOrder[customOrder[i]] = i;
            }
            String x = in.next();

            long result = trie.countLessThan(trie.root, x, 0, invOrder);
            out.println(result);
        }
    }

    public static void main(String[] args) {
        solve();
        out.close();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
