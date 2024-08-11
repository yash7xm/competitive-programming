package Trie;

import java.util.*;

public class WordSearch2 {
    public static void main(String[] args) {
        // https://leetcode.com/problems/word-search-ii/description/?envType=study-plan-v2&envId=top-interview-150
        // we will first create a trie using all the words needed 
        // then will do dfs from the board and find all the word by moving in the board and using trie
        // to avoid duplicates we will remove the flag of isEnd from the Node
        // and we are also counting the number of nodes such that when comming back we will prune that branch
        // i.e exhaust that branch for further processing
    }

    public class Node {
        Node[] childs = new Node[26];
        String str;
        int count = 0;
    }

    private Node root;

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
                curr.count++;
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.str = word;
    }

    private void dfs(char[][] board, int i, int j, Node root, List<String> res, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j]) {
            return;
        }

        if (root.childs[board[i][j] - 'a'] == null)
            return;
        Node child = root.childs[board[i][j] - 'a'];
        if (child.str != null) {
            res.add(child.str);
            child.str = null;
        }

        vis[i][j] = true;
        dfs(board, i + 1, j, child, res, vis);
        dfs(board, i - 1, j, child, res, vis);
        dfs(board, i, j + 1, child, res, vis);
        dfs(board, i, j - 1, child, res, vis);
        vis[i][j] = false;

        if (child.count == 0) {
            root.childs[board[i][j] - 'a'] = null;
            root.count--;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        root = new Node();
        for (String word : words) {
            insert(word);
        }
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res, vis);
            }
        }
        return res;
    }
}
