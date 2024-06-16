import java.util.Scanner;

public class Manhattan_Circle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            char[][] arr = new char[n][m];

            for (int i = 0; i < n; i++) {
                String line = in.next();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            int x = 0;
            int max = -1;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == '#')
                        sum++;
                }

                if (sum > max) {
                    max = sum;
                    x = i;
                }
            }

            int s = -1;
            int e = -1;
            for (int j = 0; j < m; j++) {
                if (arr[x][j] == '#' && s == -1) {
                    s = j;
                    e = j;
                } else if (arr[x][j] == '#' && s != -1) {
                    e = j;
                }
            }

            int y = (e + s) / 2;
            x++;
            y++;
            System.out.println(x + " " + y);
        }
        in.close();
    }
}
