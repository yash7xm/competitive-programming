import java.util.Scanner;

public class BitStrings {

    static final int MOD = 1000000007;

    public static long modularExponentiation(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;

            exp >>= 1;

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(modularExponentiation(2, n, MOD));
        in.close();
    }
}
