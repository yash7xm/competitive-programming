package Graph;

import java.util.*;

class WordLadder {

    public static void main(String[] args) {
        // https://leetcode.com/problems/word-ladder/?envType=study-plan-v2&envId=top-interview-150
        // excatly same as previous just wordList length is more but still works because of bfs 
        // and we are also storing the visited in a set 
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int lvl = 0;
        LinkedList<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.addLast(beginWord);
        set.add(beginWord);

        while (q.size() > 0) {
            int n = q.size();
            lvl++;
            while (n > 0) {
                String rem = q.removeFirst();
                if (rem.equals(endWord)) {
                    return lvl;
                }

                for (int i = 0; i < wordList.size(); i++) {
                    String interm = wordList.get(i);
                    if (set.contains(interm)) {
                        continue;
                    }
                    int cnt = 0;
                    for (int j = 0; j < interm.length(); j++) {
                        if (interm.charAt(j) != rem.charAt(j)) {
                            cnt++;
                        }
                    }
                    if (cnt == 1) {
                        q.addLast(interm);
                        set.add(interm);
                    }
                }
                n--;
            }
        }
        return 0;
    }
}