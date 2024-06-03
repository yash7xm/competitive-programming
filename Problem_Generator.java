import java.util.Scanner;

public class Problem_Generator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            String s = in.next();

            int[] arr = new int[7];
            for (int i = 0; i < n; i++) {
                arr[s.charAt(i) - 'A']++;
            }

            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= m)
                    continue;
                else
                    res += m - arr[i];
            }

            System.out.println(res);
        }
        in.close();
    }
}
