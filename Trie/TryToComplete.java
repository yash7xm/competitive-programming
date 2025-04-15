import java.io.*;
import java.util.*;

public class TryToComplete {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Trie {
        private static class Node {
            Node[] childs = new Node[26];
            String bestWord = null;
            int freq = 0;
        }

        Node root = new Node();
        Map<String, Integer> freqMap;

        public Trie(Map<String, Integer> freqMap) {
            this.freqMap = freqMap;
        }

        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.childs[idx] == null) curr.childs[idx] = new Node();
                curr = curr.childs[idx];

                int wordFreq = freqMap.get(word);
                if (curr.bestWord == null || wordFreq > freqMap.get(curr.bestWord)) {
                    curr.bestWord = word;
                    curr.freq = wordFreq;
                } else if (wordFreq == freqMap.get(curr.bestWord) && word.compareTo(curr.bestWord) < 0) {
                    curr.bestWord = word;
                    curr.freq = wordFreq;
                }
            }
        }

        public void query(String prefix) {
            Node curr = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (curr.childs[idx] == null) {
                    out.println("-1");
                    return;
                }
                curr = curr.childs[idx];
            }
            out.println(curr.bestWord + " " + curr.freq);
        }
    }

    static void solve() {
        int n = in.nextInt();
        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = in.next();
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        Trie trie = new Trie(freqMap);
        for (String word : freqMap.keySet()) {
            trie.insert(word);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            String query = in.next();
            trie.query(query);
        }
    }

    public static void main(String[] args) {
        solve();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }
}
