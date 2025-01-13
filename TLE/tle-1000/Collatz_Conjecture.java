import java.util.Scanner;

public class Collatz_Conjecture {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int k = in.nextInt();

            while (k > 0) {
                int addTo = (y - (x % y));
                if (k < addTo) {
                    x = x + k;
                    break;
                } else if (k >= addTo) {
                    x += addTo;
                    while ((x) % y == 0) {
                        x = x / y;
                    }
                    k -= addTo;
                }

                if (x <= y) {
                    if (k < (y - x)) {
                        x = x + k;
                        break;
                    } else if (k == (y - x)) {
                        x = 1;
                        break;
                    } else {
                        if ((k - (y - x)) % (y - 1) == 0) {
                            x = 1;
                            break;
                        } else {
                            int n = ((k - (y - x)) / (y - 1)) + 1;
                            x = k - ((y - x) + (n - 1) * (y - 1)) + 1;
                            break;
                        }
                    }
                }
            }

            System.out.println(x);
        }
        in.close();
    }
}
