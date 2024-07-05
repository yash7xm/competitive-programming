import java.util.HashMap;
import java.util.Scanner;

public class Distinct_Split {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            HashMap<Character, Integer> mapb = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
            }

            HashMap<Character, Integer> mapa = new HashMap<>();
            int res = 0;

            for (int i = 0; i < n - 1; i++) {
                char ch = s.charAt(i);
                mapa.put(ch, mapa.getOrDefault(ch, 0) + 1);
                mapb.put(ch, mapb.get(ch) - 1);
                if (mapb.get(ch) == 0) {
                    mapb.remove(ch);
                }

                res = Math.max(res, mapa.size() + mapb.size());
            }

            System.out.println(res);
        }
        in.close();
    }
}
