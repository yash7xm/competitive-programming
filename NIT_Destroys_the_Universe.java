import java.util.Scanner;

public class NIT_Destroys_the_Universe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    cnt++;
                    while (i < n && arr[i] > 0)
                        i++;
                }
            }

            System.out.println(cnt);
        }
        in.close();
    }
}
