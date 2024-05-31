import java.util.Scanner;

public class Verify_Password {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            boolean flag = true;
            for (int i = 0; i < n - 1; i++) {
                if (Character.isDigit(s.charAt(i + 1)) && Character.isLetter(s.charAt(i))) {
                    flag = false;
                }
            }

            if (flag) {
                int lastDigitI = 0;
                while (lastDigitI < s.length() && Character.isDigit(s.charAt(lastDigitI))) {
                    lastDigitI++;
                }
                String digits = s.substring(0, lastDigitI);
                String letters = s.substring(lastDigitI);

                boolean isSorted = true;
                for (int i = 0; i < digits.length() - 1; i++) {
                    if (digits.charAt(i) > digits.charAt(i + 1)) {
                        isSorted = false;
                        break;
                    }
                }

                for (int i = 0; i < letters.length() - 1; i++) {
                    if (letters.charAt(i) > letters.charAt(i + 1)) {
                        isSorted = false;
                        break;
                    }
                }

                if (!isSorted) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }

            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
