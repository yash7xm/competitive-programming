import java.io.*;
import java.util.*;

public class WordCombinations {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static final int MOD = (int) 1e9 + 7;

    public static class Trie {
        static class Node {
            Node[] children = new Node[26];
            boolean isEnd = false;
        }

        Node root = new Node();

        void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }
    }

    public static void main(String[] args) {
        String s = in.next();
        int n = in.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(in.next());
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 0; i < len; i++) {
            Trie.Node node = trie.root;
            for (int j = i; j < len; j++) {
                int idx = s.charAt(j) - 'a';
                if (node.children[idx] == null) break;
                node = node.children[idx];
                if (node.isEnd) {
                    dp[j + 1] = (dp[j + 1] + dp[i]) % MOD;
                }
            }
        }

        out.println(dp[len]);
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
    }
}
