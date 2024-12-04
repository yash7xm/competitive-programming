package AdventOfCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class day4part1 {

    public static class Node {
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (!line.isEmpty()) {
                ArrayList<Character> list = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    list.add(line.charAt(i));
                    if (list.get(i) == 'X') {
                        q.add(new Node(arr.size(), i, -1));
                    }
                }
                arr.add(list);
            } else {
                break;
            }
        }

        String text = "XMAS";
        int lvl = 0, cnt = 0, m = arr.size(), n = arr.get(0).size();
        while (q.size() > 0) {
            int size = q.size();
            lvl++;
            if (lvl >= text.length()) {
                cnt += q.size();
                break;
            }
            while (size-- > 0) {
                Node node = q.removeFirst();
                int r = node.r, c = node.c, d = node.d;
                char ch = text.charAt(lvl);
                if (r > 0 && arr.get(r - 1).get(c) == ch && (d == -1 || d == 1)) {
                    q.addLast(new Node(r - 1, c, 1));
                }
                if (r > 0 && c < n - 1 && arr.get(r - 1).get(c + 1) == ch && (d == -1 || d == 2)) {
                    q.addLast(new Node(r - 1, c + 1, 2));
                }
                if (c < n - 1 && arr.get(r).get(c + 1) == ch && (d == -1 || d == 3)) {
                    q.addLast(new Node(r, c + 1, 3));
                }
                if (r < m - 1 && c < n - 1 && arr.get(r + 1).get(c + 1) == ch && (d == -1 || d == 4)) {
                    q.addLast(new Node(r + 1, c + 1, 4));
                }
                if (r < m - 1 && arr.get(r + 1).get(c) == ch && (d == -1 || d == 5)) {
                    q.addLast(new Node(r + 1, c, 5));
                }
                if (r < m - 1 && c > 0 && arr.get(r + 1).get(c - 1) == ch && (d == -1 || d == 6)) {
                    q.addLast(new Node(r + 1, c - 1, 6));
                }
                if (c > 0 && arr.get(r).get(c - 1) == ch && (d == -1 || d == 7)) {
                    q.addLast(new Node(r, c - 1, 7));
                }
                if (r > 0 && c > 0 && arr.get(r - 1).get(c - 1) == ch && (d == -1 || d == 8)) {
                    q.addLast(new Node(r - 1, c - 1, 8));
                }
            }
        }

        System.out.println(cnt);

        in.close();
    }
}
