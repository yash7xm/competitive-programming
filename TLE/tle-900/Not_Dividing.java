import java.util.Scanner;

public class Not_Dividing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (arr[i] == 1)
                    arr[i]++;
            }

            for (int i = 1; i < n; i++) {
                if (arr[i] % arr[i - 1] == 0) {
                    arr[i]++;
                }
            }

            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
