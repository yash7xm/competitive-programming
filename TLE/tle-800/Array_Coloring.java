import java.util.Scanner;

public class Array_Coloring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
            }

            if (sum % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
