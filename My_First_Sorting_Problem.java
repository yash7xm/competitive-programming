import java.util.Scanner;

public class My_First_Sorting_Problem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x < y) {
                System.out.println(x + " " + y);
            } else {
                System.out.println(y + " " + x);
            }
        }
        in.close();
    }
}
