import java.util.Scanner;

public class ConstructTheString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            in.nextInt();
            int b = in.nextInt();

            int idx = 0;
            for (int i = 0; i < n; i++) {
                System.out.print((char) (idx + 'a'));
                idx = (idx + 1) % b;
            }
            System.out.println();
        }
        in.close();
    }
}
