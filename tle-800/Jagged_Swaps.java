import java.util.Scanner;

public class Jagged_Swaps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            if (arr[0] != 1) {
                System.out.println("NO");
            } else {
                for (int i = 1; i < n - 1; i++) {
                    int maxEl = n - i + 1;
                    for (int j = 1; j < maxEl - 1; j++) {
                        if (arr[j] == maxEl && arr[j - 1] < maxEl && arr[j + 1] < maxEl) {
                            int temp = arr[j + 1];
                            arr[j + 1] = arr[j];
                            arr[j] = temp;
                        }
                    }
                    if (arr[maxEl - 1] != maxEl) {
                        System.out.println("NO");
                        break;
                    }
                }

                System.out.println("YES");
            }
        }
        in.close();
    }
}
