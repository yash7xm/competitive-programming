import java.util.Scanner;

public class SwapBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int om = 0x55555555;
            int em = 0xAAAAAAAA;

            int odd = (n & om);
            int even = (n & em);

            odd <<= 1;
            even >>= 1;

            n = odd | even;

            System.out.println(n);
        }
        in.close();
    }
}
