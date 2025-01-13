import java.util.Scanner;

public class SpecialPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            for (int i = 2; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.print("1");
            System.out.println();
        }
        in.close();
    }
}
