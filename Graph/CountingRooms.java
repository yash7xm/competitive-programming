package Graph;
import java.util.Scanner;
import java.util.Stack;

public class CountingRooms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                if (ch == '#') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && arr[i][j] == 1) {
                    dfs(i, j, arr, vis);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        in.close();
    }

    public static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void dfs(int i, int j, int[][] arr, boolean[][] vis) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(i, j));

        int[][] dirs = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        while (st.size() > 0) {
            Pair rem = st.pop();

            if (vis[rem.i][rem.j])
                continue;
            vis[rem.i][rem.j] = true;

            for (int[] dir : dirs) {
                int rowdash = rem.i + dir[0];
                int coldash = rem.j + dir[1];

                if (rowdash < 0 || coldash < 0 || rowdash >= arr.length || coldash >= arr[0].length
                        || vis[rowdash][coldash] || arr[rowdash][coldash] == 0)
                    continue;

                st.push(new Pair(rowdash, coldash));
            }
        }
    }
}
