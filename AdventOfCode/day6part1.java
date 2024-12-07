package AdventOfCode;

import java.util.*;

public class day6part1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        int row = 0, col = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }

            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '^') {
                    row = grid.size();
                    col = i;
                }
                list.add(line.charAt(i));
            }
            grid.add(list);
        }

        Set<String> set = new HashSet<>();

        int dir = 1;
        int m = grid.size(), n = grid.get(0).size();
        while (row >= 0 && col >= 0 && row < m && col < n) {
            set.add(row + "," + col);
            if (dir == 1 && row > 0 && grid.get(row - 1).get(col) == '#') {
                dir = 2;
            }
            if (dir == 2 && col < n - 1 && grid.get(row).get(col + 1) == '#') {
                dir = 3;
            }
            if (dir == 3 && row < m - 1 && grid.get(row + 1).get(col) == '#') {
                dir = 4;
            }
            if (dir == 4 && col > 0 && grid.get(row).get(col - 1) == '#') {
                dir = 1;
            }

            if (dir == 1) {
                row--;
            } else if (dir == 2) {
                col++;
            } else if (dir == 3) {
                row++;
            } else if (dir == 4) {
                col--;
            }
        }

        System.out.println(set.size());
        in.close();
    }
}
