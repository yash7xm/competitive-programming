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
                mapa.put(a[i], 1);
            }

            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                mapb.put(b[i], 1);
            }

            int len = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    len++;
                } else {
                    if (mapa.containsKey(a[i - 1])) {
                        if (mapa.get(a[i - 1]) < len) {
                            mapa.put(a[i - 1], len);
                        }
                    } else {
                        mapa.put(a[i - 1], len);
                    }
                    len = 1;
                }
            }

            if (mapa.containsKey(a[n - 1])) {
                if (mapa.get(a[n - 1]) < len) {
                    mapa.put(a[n - 1], len);
                }
            } else {
                mapa.put(a[n - 1], len);
            }
            len = 1;

            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1]) {
                    len++;
                } else {
                    if (mapb.containsKey(b[i - 1])) {
                        if (mapb.get(b[i - 1]) < len) {
                            mapb.put(b[i - 1], len);
                        }
                    } else {
                        mapb.put(b[i - 1], len);
                    }
                    len = 1;
                }
            }

            if (mapb.containsKey(b[n - 1])) {
                if (mapb.get(b[n - 1]) < len) {
                    mapb.put(b[n - 1], len);
                }
            } else {
                mapb.put(b[n - 1], len);
            }
            len = 1;

            int res = 0;
            for (int key : mapa.keySet()) {
                if (mapb.containsKey(key)) {
                    res = Math.max(res, mapa.get(key) + mapb.get(key));
                }

                res = Math.max(res, mapa.get(key));
            }

            for (int key : mapb.keySet()) {
                res = Math.max(res, mapb.get(key));
            }

            System.out.println(res);

        }
        in.close();
    }
}
