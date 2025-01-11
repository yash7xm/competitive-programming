import java.util.Scanner;

public class ThreePalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            if (i % 2 == 0) {
                sb.append("aa");
            } else {
                sb.append("bb");
            }
        }

        if (n % 2 != 0) {
            if (sb.length() == 0) {
                sb.append("a");
            } else {
                if (sb.charAt(sb.length() - 1) == 'a') {
                    sb.append("b");
                } else {
                    sb.append("a");
                }
            }
        }

        System.out.println(sb.toString());
        in.close();
    }
}