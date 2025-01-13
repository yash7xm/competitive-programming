import java.util.ArrayList;
import java.util.Scanner;

public class Sequence_Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    list.add(arr[i]);
                    continue;
                }

                if (arr[i] < arr[i - 1]) {
                    list.add(arr[i]);
                    list.add(arr[i]);
                } else {
                    list.add(arr[i]);
                }
            }

            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

            list.clear();
        }
        in.close();
    }
}
