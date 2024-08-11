package Graph;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        // https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
        // did a bfs approach and moved forward by adding all the genes which are
        // different by 1
        // then lvl just tells us how long to reach endGene in shortes time
        // and also used a set to avoid any cycles as if (endGene) not found then we
        // will get into an infinite loop
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        int lvl = -1;
        LinkedList<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.addLast(startGene);
        set.add(startGene);

        while (q.size() > 0) {
            int n = q.size();
            lvl++;
            while (n > 0) {
                String rem = q.removeFirst();
                if (rem.equals(endGene)) {
                    return lvl;
                }

                for (int i = 0; i < bank.length; i++) {
                    String interm = bank[i];
                    if (set.contains(interm)) {
                        continue;
                    }
                    int cnt = 0;
                    for (int j = 0; j < 8; j++) {
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
        return -1;
    }
}
