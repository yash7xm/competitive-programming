package Divide_And_Conquer;

import java.util.Scanner;

public class MergeSort {

    static int n, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();

        if (k % 2 == 0 || k > 2 * n - 1) {
            System.out.println("-1");
            in.close();
            return;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }

        unsort(res, 0, n);

        if (k >= 2) {
            System.out.println("-1");
            in.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        in.close();
    }

    static void unsort(int[] arr, int start, int end) {
        if (k == 1 || start + 1 >= end) {
            return;
        }

        int mid = (start + end) / 2;

        int temp = arr[mid];
        arr[mid] = arr[mid - 1];
        arr[mid - 1] = temp;

        k -= 2;

        unsort(arr, start, mid);
        unsort(arr, mid, end);
    }
}
