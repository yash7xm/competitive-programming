import java.util.Arrays;
import java.util.Scanner;

public class Final_Boss {

    static class Pair implements Comparable<Pair> {
        int a;
        int c;

        Pair(int a, int c) {
            this.a = a;
            this.c = c;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.c, other.c);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int h = in.nextInt();
            int n = in.nextInt();

            int[] arr = new int[n];
            int[] cool = new int[n];

            int ta = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                ta += arr[i];
            }

            int maxCool = 0;
            Pair[] pairs = new Pair[n];

            for (int i = 0; i < n; i++) {
                cool[i] = in.nextInt();
                pairs[i] = new Pair(arr[i], cool[i]);
                maxCool = Math.max(maxCool, cool[i]);
                maxCool = Math.max(maxCool, cool[i]);
            }

            Arrays.sort(pairs);

            long res = 0;
            if (h / ta <= 1) {
                res = 1;
            } else {
                if (h % ta == 0) {
                    res = (h / ta - 1) * maxCool;
                    res++;
                } else {
                    int tempH = h - h % ta;
                    res = (tempH / ta - 1) * maxCool;
                    res++;

                    for (int i = 0; i < n; i++) {
                        tempH += pairs[i].a;
                        res += maxCool - pairs[i].c;
                        if (tempH >= h) {
                            break;
                        }
                    }
                }
            }

            System.out.println(res);
        }
        in.close();
    }
}