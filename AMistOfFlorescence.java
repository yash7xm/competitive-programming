import java.util.Scanner;

public class AMistOfFlorescence {

    static int A, B, C, D;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        A = in.nextInt();
        B = in.nextInt();
        C = in.nextInt();
        D = in.nextInt();

        int[][] arr = new int[20][20];
        arr[0][0] = 1;
        A--;
        dfs(arr, 0, 0, 1);

        System.out.println("50 50");
        for (int[] row : arr) {
            for (int type : row) {
                if (type == 1) {
                    System.out.print("A");
                } else if (type == 2) {
                    System.out.print("B");
                } else if (type == 3) {
                    System.out.print("C");
                } else if (type == 4) {
                    System.out.print("D");
                }
            }
            System.out.println();
        }
        in.close();
    }

    static void dfs(int[][] arr, int row, int col, int type) {
        if (row > arr.length && col > arr[0].length && row < 0 && col < 0 && A <= 0 && B <= 0 && C <= 0 && D <= 0) {
            return;
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r < arr.length && c < arr[0].length && r >= 0 && c >= 0 &&
                    arr[r][c] == 0) {
                if (A > 0 && check(arr, r, c, 1)) {
                    arr[r][c] = 1;
                    A--;
                    dfs(arr, r, c, 1);
                } else if (B > 0 && check(arr, r, c, 2)) {
                    arr[r][c] = 2;
                    B--;
                    dfs(arr, r, c, 2);
                } else if (C > 0 && check(arr, r, c, 3)) {
                    arr[r][c] = 3;
                    C--;
                    dfs(arr, r, c, 3);
                } else if (D > 0 && check(arr, r, c, 4)) {
                    arr[r][c] = 4;
                    D--;
                    dfs(arr, r, c, 4);
                } else {
                    arr[r][c] = type;
                    dfs(arr, r, c, type);
                }
            }
        }
    }

    static boolean check(int[][] arr, int row, int col, int type) {
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r < arr.length && c < arr[0].length && r >= 0 && c >= 0 &&
                    arr[r][c] == type) {
                return false;
            }
        }

        return true;
    }
}
