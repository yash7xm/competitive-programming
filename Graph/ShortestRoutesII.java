package Graph;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestRoutesII {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int q = scn.nextInt();

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            dist[u - 1][v - 1] = Math.min(dist[u - 1][v - 1], wt);
            dist[v - 1][u - 1] = Math.min(dist[v - 1][u - 1], wt);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int x = scn.nextInt() - 1;
            int y = scn.nextInt() - 1;

            System.out.println(dist[x][y] == Integer.MAX_VALUE ? -1 : dist[x][y]);
        }

        scn.close();
    }
}
