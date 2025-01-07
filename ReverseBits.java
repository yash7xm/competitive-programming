import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long rev = 0;
            for (int i = 31, idx = 0; i >= 0; i--, idx++) {
                if ((n & (1L << idx)) != 0) {
                    rev = (rev | (1L << i));
                }
            }

            System.out.println(rev);
        }
        in.close();
    }
}
