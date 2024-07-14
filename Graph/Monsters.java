package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Monsters {

    static Pair start;
    static Pair end;
    static Queue<Pair> mq;
    static Pair[][] parent;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        char[][] arr = new char[n][m];
        mq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = scn.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'A') {
                    start = new Pair(i, j);
                }
                if (arr[i][j] == 'M') {
                    mq.add(new Pair(i, j));
                }
            }
        }

        int[][] vis = new int[n][m];
        for (int[] v : vis) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        monsterBFS(arr, vis);

        boolean[][] avis = new boolean[n][m];
        parent = new Pair[n][m];

        if (!bfs(arr, vis, avis)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            ArrayList<Character> ans = new ArrayList<>();
            for (Pair rem = end; rem != null; rem = parent[rem.i][rem.j]) {
                Pair par = parent[rem.i][rem.j];
                if (par == null)
                    break;
                if (rem.i + 1 == par.i && rem.j == par.j) {
                    ans.add('U');
                } else if (rem.i == par.i && rem.j - 1 == par.j) {
                    ans.add('R');
                } else if (rem.i - 1 == par.i && rem.j == par.j) {
                    ans.add('D');
                } else if (rem.i == par.i && rem.j + 1 == par.j) {
                    ans.add('L');
                }
            }

            System.out.println(ans.size());
            for (int i = ans.size() - 1; i >= 0; i--) {
                System.out.print(ans.get(i));
            }
            System.out.println();
        }

        scn.close();
    }

    public static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean bfs(char[][] arr, int[][] vis, boolean[][] avis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);

        int[][] dirs = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        int lvl = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                Pair rem = q.poll();
                if (avis[rem.i][rem.j])
                    continue;

                avis[rem.i][rem.j] = true;

                if ((rem.i == 0 || rem.i == arr.length - 1) || (rem.j == 0 || rem.j == arr[0].length - 1)) {
                    end = new Pair(rem.i, rem.j);
                    return true;
                }

                for (int[] dir : dirs) {
                    int rowdash = rem.i + dir[0];
                    int coldash = rem.j + dir[1];

                    if (rowdash < 0 || coldash < 0 || rowdash >= arr.length || coldash >= arr[0].length
                            || arr[rowdash][coldash] != '.' || vis[rowdash][coldash] <= lvl + 1
                            || avis[rowdash][coldash]) {
                        continue;
                    }

                    q.add(new Pair(rowdash, coldash));
                    parent[rowdash][coldash] = new Pair(rem.i, rem.j);
                }
            }
            lvl++;
        }

        return false;
    }

    private static void monsterBFS(char[][] arr, int[][] vis) {
        int[][] dirs = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        int lvl = 0;

        while (!mq.isEmpty()) {
            int n = mq.size();
            while (n-- > 0) {
                Pair rem = mq.poll();

                if (vis[rem.i][rem.j] <= lvl) {
                    continue;
                }

                vis[rem.i][rem.j] = lvl;

                for (int[] dir : dirs) {
                    int rowdash = rem.i + dir[0];
                    int coldash = rem.j + dir[1];

                    if (rowdash < 0 || coldash < 0 || rowdash >= arr.length || coldash >= arr[0].length
                            || vis[rowdash][coldash] <= lvl + 1 || arr[rowdash][coldash] == '#') {
                        continue;
                    }

                    mq.add(new Pair(rowdash, coldash));
                }
            }
            lvl++;
        }
    }
}
