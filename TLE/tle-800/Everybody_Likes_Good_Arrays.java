import java.util.Scanner;

public class Everybody_Likes_Good_Arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                if ((arr[i] % 2 == 0 && arr[i + 1] % 2 != 0) || (arr[i + 1] % 2 == 0 && arr[i] % 2 != 0)) {
                    continue;
                }
                ans++;
            }

            System.out.println(ans);
        }
        in.close();
    }
}
