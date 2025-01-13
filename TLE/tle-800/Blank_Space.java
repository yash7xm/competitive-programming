import java.util.Scanner;

public class Blank_Space {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int count = 0;
            int max = 0;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num == 1) {
                    max = Math.max(count, max);
                    count = 0;
                } else {
                    count++;
                }
            }

            max = Math.max(count, max);
            System.out.println(max);
        }
        in.close();
    }
}
