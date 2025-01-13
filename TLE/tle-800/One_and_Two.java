import java.util.Scanner;

public class One_and_Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] pre = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int numOfTwo = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 2)
                    numOfTwo++;
                pre[i] = numOfTwo;
            }

            int k = -1;
            for (int i = 0; i < n - 1; i++) {
                if (pre[i] == pre[n - 1] - pre[i]) {
                    k = i + 1;
                    break;
                }
            }

            System.out.println(k);
        }
        in.close();
    }
}
