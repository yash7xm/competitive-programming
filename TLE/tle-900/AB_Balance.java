import java.util.Scanner;

public class AB_Balance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                System.out.println(s);
            } else {
                if (s.charAt(0) == 'a') {
                    System.out.println('b' + s.substring(1, s.length()));
                } else {
                    System.out.println('a' + s.substring(1, s.length()));
                }
            }
        }
        in.close();
    }
}
