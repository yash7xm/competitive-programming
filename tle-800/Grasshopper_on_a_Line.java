import java.util.Scanner;

public class Grasshopper_on_a_Line {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int x = in.nextInt();
            int k = in.nextInt();

            if (x % k == 0) {
                System.out.println(2);
                System.out.println(x - 1 + " " + "1");
            } else {
                System.out.println(1);
                System.out.println(x);
            }
        }
        in.close();
    }
}