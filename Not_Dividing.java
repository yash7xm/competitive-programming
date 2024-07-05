import java.util.Scanner;

public class Not_Dividing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            for (int i = 0; i < n - 1; i++) {
                if (arr[i] % arr[i + 1] == 0) {
                    long temp = arr[i];
                    if ((temp + 1) % arr[i + 1] != 0) {
                        arr[i] = temp + 1;
                    } else if ((temp + 2) % arr[i + 1] != 0) {
                        arr[i] = temp + 2;
                    }
                }
            }

            for (long el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
