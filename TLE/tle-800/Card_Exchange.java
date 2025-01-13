import java.util.Scanner;

public class Card_Exchange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                count = 0;
                for (int j = i; j < n; j++) {
                    if (arr[i] == arr[j])
                        count++;
                }
                if (count >= k) {
                    break;
                }
            }

            if (count >= k) {
                System.out.println(k - 1);
            } else {
                System.out.println(n);
            }
        }
        in.close();
    }
}
