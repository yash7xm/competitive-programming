import java.util.Scanner;

public class Make_it_Divisible_by_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();
            String str = "" + n;
            int ans[] = new int[1];
            ans[0] = Integer.MAX_VALUE;
            helper(str, "", 0, ans);
            System.out.println(ans[0]);
        }
        in.close();
    }

    public static void helper(String str, String curr, int i, int[] ans) {

        if (i >= str.length()) {
            if (curr == "")
                return;
            long number = Long.parseLong(curr);
            if (number % 25 == 0) {
                ans[0] = Math.min(ans[0], str.length() - curr.length());
            }
            return;
        }

        helper(str, curr, i + 1, ans);
        helper(str, curr + str.charAt(i), i + 1, ans);
    }
}
