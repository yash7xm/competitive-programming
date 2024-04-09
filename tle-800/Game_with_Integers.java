import java.util.Scanner;

public class Game_with_Integers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            if (((n + 1) % 3 == 0) || ((n - 1) % 3 == 0)) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        }
        in.close();
    }
}