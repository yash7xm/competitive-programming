import java.util.Scanner;

public class Olya_and_Game_with_Arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];

            int min = Integer.MAX_VALUE;
            int sleastMin = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                int least = Integer.MAX_VALUE;
                int sleast = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    int el = in.nextInt();
                    if (el <= least) {
                        sleast = least;
                        least = el;
                    } else if (el <= sleast) {
                        sleast = el;
                    }
                }

                arr[i][0] = least;
                arr[i][1] = sleast;

                min = Math.min(arr[i][0], min);
                sleastMin = Math.min(arr[i][1], sleastMin);
            }

            long res = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (arr[i][1] == sleastMin && !flag) {
                    flag = true;
                } else {
                    res += arr[i][1];
                }
            }

            res += min;

            System.out.println(res);
        }
        in.close();
    }
}
