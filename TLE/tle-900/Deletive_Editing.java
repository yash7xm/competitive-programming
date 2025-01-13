import java.util.HashMap;
import java.util.Scanner;

public class Deletive_Editing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n-- > 0) {
            String s = in.next();
            String t = in.next();

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int sptr = s.length() - 1;
            int tptr = t.length() - 1;

            while (tptr >= 0 && sptr >= 0) {
                if (map.containsKey(s.charAt(sptr))) {
                    if (map.get(s.charAt(sptr)) > 0 && s.charAt(sptr) == t.charAt(tptr)) {
                        if (map.get(s.charAt(sptr)) > 0) {
                            map.put(s.charAt(sptr), map.get(s.charAt(sptr)) - 1);
                        }
                        sptr--;
                        tptr--;
                    } else if (map.get(s.charAt(sptr)) > 0 && s.charAt(sptr) != t.charAt(tptr)) {
                        break;
                    } else if (map.get(s.charAt(sptr)) == 0) {
                        sptr--;
                    }
                } else {
                    sptr--;
                }
            }

            if (tptr < 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
