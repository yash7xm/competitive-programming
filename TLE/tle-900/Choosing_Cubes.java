import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Choosing_Cubes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int f = in.nextInt();
            int k = in.nextInt();

            int fav = 0;

            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (i == f - 1)
                    fav = arr[i];
            }

            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });

            int st = -1;
            int et = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == fav) {
                    st = i;
                    et = i;
                    i++;
                    while (i < n && arr[i] == fav) {
                        et++;
                        i++;
                    }
                    break;
                }
            }

            k = k - 1;
            if (k >= st && k < et)
                System.out.println("MAYBE");
            else if (k >= st && k == et)
                System.out.println("YES");
            else if (k < st)
                System.out.println("NO");
            else if (k >= et)
                System.out.println("YES");

        }
        in.close();
    }
}
