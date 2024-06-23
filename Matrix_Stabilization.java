import java.util.Scanner;

public class Matrix_Stabilization {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int a = i != 0 ? arr[i - 1][j] : -1;
                    int b = j != 0 ? arr[i][j - 1] : -1;
                    int c = i != n - 1 ? arr[i + 1][j] : -1;
                    int d = j != m - 1 ? arr[i][j + 1] : -1;

                    int temp = -1;
                    int cnt = 0;
                    if (arr[i][j] > a) {
                        temp = Math.max(temp, a);
                        cnt++;
                    }
                    if (arr[i][j] > b) {
                        temp = Math.max(temp, b);
                        cnt++;
                    }
                    if (arr[i][j] > c) {
                        temp = Math.max(temp, c);
                        cnt++;
                    }
                    if (arr[i][j] > d) {
                        temp = Math.max(temp, d);
                        cnt++;
                    }

                    if (temp != -1 && cnt == 4) {
                        arr[i][j] = temp;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
        in.close();
    }
}
