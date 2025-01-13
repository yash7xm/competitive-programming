import java.util.Scanner;

public class Swap_and_Delete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            int ones = 0;
            int zeroes = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    zeroes++;
                else
                    ones++;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (ones == 0)
                        break;
                    else
                        ones--;
                } else {
                    if (zeroes == 0)
                        break;
                    else
                        zeroes--;
                }
            }

            System.out.println(ones + zeroes);
        }
        in.close();
    }
}
