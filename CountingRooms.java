import java.util.Scanner;

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

    public static void dfs(int i, int j, int[][] arr, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || vis[i][j] || arr[i][j] == 0)
            return;
        vis[i][j] = true;
        dfs(i + 1, j, arr, vis);
        dfs(i - 1, j, arr, vis);
        dfs(i, j + 1, arr, vis);
        dfs(i, j - 1, arr, vis);
    }
}
