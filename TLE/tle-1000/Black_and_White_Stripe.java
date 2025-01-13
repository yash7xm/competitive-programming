import java.util.Scanner;

public class Black_and_White_Stripe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'W')
                    arr[i] = 1;
                else
                    arr[i] = 0;

                if (i != 0)
                    arr[i] += arr[i - 1];
            }

            int res = n + 1;
            int i = 0;
            int j = k - 1;

            while (j < n) {
                res = Math.min(res, arr[j] - (i > 0 ? arr[i - 1] : 0));
                i++;
                j++;
            }

            System.out.println(res);
        }
        in.close();
    }
}
