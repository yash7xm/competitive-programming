import java.util.Scanner;

public class EhAbAnDgCd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            System.out.println(1 + " " + (x - 1));
        }
        in.close();
    }
}
