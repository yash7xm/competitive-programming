import java.util.Scanner;

public class Clock_and_Strings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            boolean foundC = false;
            boolean foundD = false;

            for (int i = a;; i++) {
                if (i > 12)
                    i %= 12;
                if (i == c)
                    foundC = true;
                else if (i == d)
                    foundD = true;
                if (i == b)
                    break;
            }

            if ((foundC && !foundD) || (!foundC && foundD)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
