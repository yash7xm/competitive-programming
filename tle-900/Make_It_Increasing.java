import java.util.Scanner;

public class Make_It_Increasing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int ans = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            for (int i = n - 2; i >= 0; i--) {
                while (arr[i] >= arr[i + 1] && arr[i] > 0) {
                    arr[i] /= 2;
                    ans++;
                }
                if (arr[i] == arr[i + 1]) {
                    ans = -1;
                    break;
                }
            }
            System.out.println(ans);
        }
        in.close();
    }
}
