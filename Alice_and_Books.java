import java.util.Scanner;

public class Alice_and_Books {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(arr[i], max);
            }

            System.out.println(max + arr[n - 1]);
        }
        in.close();
    }
}
