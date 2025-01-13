import java.util.Scanner;

public class Unit_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int numOfNegOnes = 0;
            int numOfPosOnes = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num == -1)
                    numOfNegOnes++;
                else
                    numOfPosOnes++;
            }

            if (numOfPosOnes >= numOfNegOnes) {
            } else {
                int rem = numOfNegOnes - numOfPosOnes;
                if (rem % 2 == 0) {
                    res += rem / 2;
                } else {
                    res += rem / 2 + 1;
                }
            }

            numOfNegOnes -= res;
            numOfPosOnes += res;

            if (numOfNegOnes % 2 != 0)
                res++;
            System.out.println(res);
        }
        in.close();
    }
}
