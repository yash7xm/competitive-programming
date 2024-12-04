package AdventOfCode;

import java.util.ArrayList;
import java.util.Scanner;

public class day4part2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (!line.isEmpty()) {
                ArrayList<Character> list = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    list.add(line.charAt(i));
                }
                arr.add(list);
            } else {
                break;
            }
        }

        int m = arr.size(), n = arr.get(0).size();
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr.get(i).get(j) == 'A') {
                    if (check(arr, i, j, m, n)) {
                        res++;
                    }
                }
            }
        }

        System.out.println(res);

        in.close();
    }

    private static boolean check(ArrayList<ArrayList<Character>> arr, int r, int c, int m, int n) {
        int cnt = 0;
        if (((r > 0 && c < n - 1 && arr.get(r - 1).get(c + 1) == 'S')
                && (r < m - 1 && c > 0 && arr.get(r + 1).get(c - 1) == 'M')) ||
                ((r > 0 && c < n - 1 && arr.get(r - 1).get(c + 1) == 'M')
                        && (r < m - 1 && c > 0 && arr.get(r + 1).get(c - 1) == 'S'))) {
            cnt++;
        }

        if (((r > 0 && c > 0 && arr.get(r - 1).get(c - 1) == 'S')
                && (r < m - 1 && c < n - 1 && arr.get(r + 1).get(c + 1) == 'M')) ||
                ((r > 0 && c > 0 && arr.get(r - 1).get(c - 1) == 'M')
                        && (r < m - 1 && c < n - 1 && arr.get(r + 1).get(c + 1) == 'S'))) {
            cnt++;
        }

        return cnt == 2 ? true : false;
    }
}
