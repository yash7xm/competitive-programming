import java.util.Scanner;

public class Make_it_Divisible_by_25_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();
            String str = "" + n;
            int count = 0;
            char last = '0';
            int i = str.length() - 1;
            while (i >= 0) {
                if (str.charAt(i) == '0' || str.charAt(i) == '5') {
                    last = str.charAt(i);
                    i--;
                    break;
                }
                i--;
                count++;
            }

            while (i >= 0) {
                if (last == '0' && (str.charAt(i) == '0' || str.charAt(i) == '5')) {
                    i--;
                    break;
                } else if (last == '5' && (str.charAt(i) == '2' || str.charAt(i) == '7')) {
                    i--;
                    break;
                }
                i--;
                count++;
            }

            System.out.println(count);
        }
        in.close();
    }
}
