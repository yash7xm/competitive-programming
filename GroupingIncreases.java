import java.util.ArrayList;
import java.util.Scanner;

public class GroupingIncreases {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            list1.add(Integer.MAX_VALUE);
            list2.add(Integer.MAX_VALUE);

            long res = 0;
            for (int i = 0; i < n; i++) {
                int x = list1.get(list1.size() - 1);
                int y = list2.get(list2.size() - 1);

                if (arr[i] <= x && arr[i] <= y) {
                    if (x <= y) {
                        list1.add(arr[i]);
                    } else {
                        list2.add(arr[i]);
                    }
                } else if (arr[i] > x && arr[i] > y) {
                    if (x <= y) {
                        list1.add(arr[i]);
                    } else {
                        list2.add(arr[i]);
                    }
                    res++;
                } else {
                    if (x <= y) {
                        list2.add(arr[i]);
                    } else {
                        list1.add(arr[i]);
                    }
                }

            }

            System.out.println(res);
        }
        in.close();
    }
}
