import java.util.Scanner;

public class Shoe_Shuffling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            boolean flag = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    flag = true;
                    break;
                }
            }

            if (flag || n == 1) {
                System.out.println(-1);
            } else {
                System.out.print(n + " ");
                for (int i = 1; i < n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        in.close();
    }
}
