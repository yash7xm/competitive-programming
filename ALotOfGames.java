import java.io.*;
import java.util.*;

public class ALotOfGames {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static class Trie {
        private static class Node {
            Node[] childs = new Node[26];
        }

        public static Node root;

        public Trie() {
            root = new Node();
        }

        public static void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (curr.childs[i] == null) {
                    curr.childs[i] = new Node();
                }
                curr = curr.childs[i];
            }
        }

        public static boolean canWin(Node node) {
            for (Node child : node.childs) {
                if (child != null && !canWin(child)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean canLose(Node node) {
            boolean hasChild = false;
            for (Node child : node.childs) {
                if (child != null) {
                    hasChild = true;
                    if (!canLose(child)) {
                        return true;
                    }
                }
            }
            return !hasChild;
        }
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();

        Trie t = new Trie();
        for (int i = 0; i < n; i++) {
            t.insert(in.next());
        }

        boolean win = Trie.canWin(Trie.root);
        boolean lose = Trie.canLose(Trie.root);

        if (!win) {
            out.println("Second");
        } else if (lose) {
            out.println("First");
        } else {
            out.println((k % 2 == 1) ? "First" : "Second");
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
            while (st == null || !st.hasMoreTokens()) {
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
