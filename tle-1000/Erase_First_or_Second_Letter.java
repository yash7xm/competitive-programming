import java.util.HashSet;
import java.util.Scanner;

public class Erase_First_or_Second_Letter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            HashSet<String> set = new HashSet<>();

            helper(s, set);

            n = n - 1;
            System.out.println(set.size());
        }
        in.close();
    }

    public static void helper(String s, HashSet<String> set) {
        if (s.length() == 1) {
            set.add(s);
            return;
        }

        if (set.contains(s)) {
            return;
        }

        helper(s.substring(1, s.length()), set);
        helper(s.charAt(0) + s.substring(2, s.length()), set);

        set.add(s);
    }
}
