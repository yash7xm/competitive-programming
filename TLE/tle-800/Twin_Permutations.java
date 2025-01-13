import java.util.Scanner;

public class Twin_Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            b[0] = arr[0];

            for (int i = 0; i < n; i++) {
                // b[i] = arr[i - 1] - arr[i] + b[i - 1];
                b[i] = (n + 1) - arr[i];
            }

            for (int i = 0; i < n; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();

        }
        in.close();
    }
}
