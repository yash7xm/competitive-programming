import java.util.*;

public class ShortCode {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal = false;
    }

    static TrieNode root = new TrieNode();

    static void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isTerminal = true;
    }

    static PriorityQueue<Integer> merge(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
        if (a.size() > b.size()) {
            PriorityQueue<Integer> tmp = a;
            a = b;
            b = tmp;
        }
        b.addAll(a);
        return b;
    }

    static PriorityQueue<Integer> dfs(TrieNode node, int depth) {
        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder()); 

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                PriorityQueue<Integer> child = dfs(node.children[i], depth + 1);
                res = merge(res, child);
            }
        }

        if (node.isTerminal) {
            res.add(depth);
        } else if (depth != 0 && !res.isEmpty()) {
            res.poll();
            res.add(depth);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            insert(word);
        }

        PriorityQueue<Integer> result = dfs(root, 0);
        int total = 0;
        for (int d : result) total += d;
        System.out.println(total);
    }
}
