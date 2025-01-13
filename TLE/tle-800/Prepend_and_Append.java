import java.util.Scanner;

public class Prepend_and_Append {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            int l = 0;
            int h = n - 1;

            while (l <= h) {
                if (s.charAt(l) == s.charAt(h))
                    break;
                l++;
                h--;
            }

            if (l > h)
                System.out.println(0);
            else
                System.out.println(h - l + 1);
        }

        in.close();
    }
}
