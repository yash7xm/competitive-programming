import java.util.Scanner;

public class Least_Product {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int cnt = 0;
            int flag = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (arr[i] < 0) {
                    cnt++;
                }
                if (arr[i] == 0) {
                    flag = 1;
                }
            }

            if (flag == 1) {
                System.out.println(0);
            } else if (cnt % 2 != 0) {
                System.out.println(0);
            } else if (cnt % 2 == 0) {
                System.out.println(1);
                System.out.println(1 + " " + 0);
            }
        }
        in.close();
    }
}
