import java.util.Scanner;

public class Two_Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            if(a + b + 2 <= n || (a==b && b==n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
