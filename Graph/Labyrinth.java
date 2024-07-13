package Graph;
import java.util.LinkedList;
import java.util.Scanner;

public class Labyrinth {

    public static class Pair {
        int i;
        int j;
        String psf;

        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    static Pair start;
    static Pair end;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = scn.next();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                if (ch == '#') {
                    arr[i][j] = 0;
                } else if (ch == '.') {
                    arr[i][j] = 1;
                } else if (ch == 'A') {
                    start = new Pair(i, j, "");
                    arr[i][j] = 1;
                } else if (ch == 'B') {
                    end = new Pair(i, j, "");
                    arr[i][j] = 1;
                }
            }
        }

        boolean[][] vis = new boolean[n][m];
        String res = bfs(arr, vis);

        if (res.equals("!")) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(res.length());
            System.out.println(res);
        }

        scn.close();
    }

    public static String bfs(int[][] arr, boolean[][] vis) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(start);
        int n = arr.length;
        int m = arr[0].length;

        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();

            if (vis[rem.i][rem.j])
                continue;

            vis[rem.i][rem.j] = true;

            if (rem.i == end.i && rem.j == end.j) {
                return rem.psf;
            }

            if (rem.i < n - 1) {
                if (!vis[rem.i + 1][rem.j] && arr[rem.i + 1][rem.j] == 1)
                    queue.addLast(new Pair(rem.i + 1, rem.j, rem.psf + "D"));
            }
            if (rem.i > 0) {
                if (!vis[rem.i - 1][rem.j] && arr[rem.i - 1][rem.j] == 1)
                    queue.addLast(new Pair(rem.i - 1, rem.j, rem.psf + "U"));
            }
            if (rem.j < m - 1) {
                if (!vis[rem.i][rem.j + 1] && arr[rem.i][rem.j + 1] == 1)
                    queue.addLast(new Pair(rem.i, rem.j + 1, rem.psf + "R"));
            }
            if (rem.j > 0) {
                if (!vis[rem.i][rem.j - 1] && arr[rem.i][rem.j - 1] == 1)
                    queue.addLast(new Pair(rem.i, rem.j - 1, rem.psf + "L"));
            }
        }

        return "!";
    }
}
