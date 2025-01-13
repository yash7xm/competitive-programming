import java.util.Scanner;

public class Halloumi_Boxes {

    public static boolean checkSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            if (k >= 2) {
                System.out.println("YES");
            } else {
                if (checkSorted(arr)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        in.close();
    }
}