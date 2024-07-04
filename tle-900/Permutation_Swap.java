import java.util.Scanner;

public class Permutation_Swap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int diff = Math.abs(arr[i] - (i + 1));
                if (diff < min && diff != 0) {
                    min = diff;
                }
            }

            System.out.println(min);
        }
        in.close();
    }
}
