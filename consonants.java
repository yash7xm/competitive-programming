import java.util.Scanner;

public class consonants {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            int[] chars = new int[26];
            chars['a' - 'a'] = 1;
            chars['e' - 'a'] = 1;
            chars['i' - 'a'] = 1;
            chars['o' - 'a'] = 1;
            chars['u' - 'a'] = 1;

            int count = 0;
            for (int i = 1; i < n; i++) {
                char ch = s.charAt(i);
                char prev = s.charAt(i-1);
                if(chars[ch-'a'] == 0 && chars[prev-'a'] == 0) {
                    count++;
                } else {
                    count = 0;
                }

                if(count > 3) {

                }
            }
        }
        in.close();
    }
}
