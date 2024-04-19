import java.util.Scanner;

public class Buttons {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (c % 2 == 0) {
                if (a > b) {
                    System.out.println("First");
                } else {
                    System.out.println("Second");
                }
            } else {
                if (a < b) {
                    System.out.println("Second");
                } else {
                    System.out.println("First");
                }
            }
        }
        in.close();
    }
}
