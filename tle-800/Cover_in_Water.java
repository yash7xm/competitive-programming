import java.util.Scanner;

public class Cover_in_Water {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            // checking consecutive empty cells
            boolean flag = false;
            for (int i = 2; i < n; i++) {
                if (s.charAt(i - 2) == '.' && s.charAt(i - 1) == '.' && s.charAt(i) == '.') {
                    flag = true;
                }
            }

            // counting no of emptyl cells
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '.')
                    count++;
            }

            if (flag) {
                System.out.println(2);
            } else {
                System.out.println(count);
            }
        }
        in.close();
    }
}
