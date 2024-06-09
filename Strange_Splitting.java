import java.util.Scanner;

public class Strange_Splitting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int count = 1;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (i > 0 && arr[i] == arr[i - 1])
                    count++;
            }

            int ridx = -1;

            if (count == n) {
                System.out.println("NO");
            } else {
                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        if (arr[n - 1] - arr[1] != 0) {
                            ridx = i;
                            break;
                        }
                    } else if (i == n - 1) {
                        if (arr[n - 2] - arr[0] != 0) {
                            ridx = i;
                            break;
                        }
                    } else {
                        if (arr[n - 1] - arr[0] != 0) {
                            ridx = i;
                            break;
                        }
                    }
                }

                if (ridx == -1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                    for (int i = 0; i < n; i++) {
                        if (i == ridx) {
                            System.out.print("R");
                        } else {
                            System.out.print("B");
                        }
                    }
                    System.out.println();
                }
            }
        }
        in.close();
    }
}
