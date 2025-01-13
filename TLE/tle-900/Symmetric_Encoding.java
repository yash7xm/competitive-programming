import java.util.HashMap;
import java.util.Scanner;

public class Symmetric_Encoding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            HashMap<Character, Character> map = new HashMap<>();

            char[] arr = new char[26];
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                arr[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char) (i + 'a'));
                }
            }

            String a = sb.toString();
            int len = a.length();
            for (int i = 0; i <= len / 2; i++) {
                map.put(a.charAt(i), a.charAt(len - i - 1));
                map.put(a.charAt(len - i - 1), a.charAt(i));
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                res.append(map.get(s.charAt(i)));
            }

            System.out.println(res.toString());
        }
        in.close();
    }
}
