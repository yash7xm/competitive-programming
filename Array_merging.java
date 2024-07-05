import java.util.HashMap;
import java.util.Scanner;

public class Array_merging {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            HashMap<Integer, Integer> mapa = new HashMap<>();
            HashMap<Integer, Integer> mapb = new HashMap<>();

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                mapa.put(a[i], mapa.getOrDefault(a[i], 0) + 1);
            }

            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                mapb.put(b[i], mapb.getOrDefault(b[i], 0) + 1);
            }

            int res = 0;
            int i = 0;
            int j = 0;

            int len = 1;
            while (i < n && j < n) {
                if (a[i] == b[i]) {
                    if (mapa.get(a[i]) > mapb.get(b[i])) {
                        mapa.put(a[i], mapa.get(a[i]) - 1);
                        i++;
                    } else {
                        mapb.put(b[j], mapb.get(b[j]) - 1);
                        j++;
                    }
                    len++;
                } else {
                    if (mapa.get(a[i]) > mapb.get(b[i])) {
                        i++;
                    } else {
                        j++;
                    }
                    res = Math.max(res, len);
                    len = 1;
                }
            }

            
            System.out.println(res);

        }
        in.close();
    }
}
