import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Mathematical_Problem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            Map<String, Integer> memo = new HashMap<>();
            System.out.println(helper(s, n - 2, memo));
        }
        in.close();
    }

    private static int helper(String s, int x, Map<String, Integer> memo) {
        if (x == 0) {
            return Integer.parseInt(s);
        }
        String key = s + "," + x;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length() - x; i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);

            int leftval = Integer.parseInt(left);

            int addResult = leftval + helper(right, x - 1, memo);
            res = Math.min(res, addResult);

            int multResult = leftval * helper(right, x - 1, memo);
            res = Math.min(res, multResult);
        }

        memo.put(key, res);
        return res;
    }
}
