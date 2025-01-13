import java.util.HashMap;
import java.util.Scanner;

public class Chemistry {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }

            int numOfOddOcc = 0;
            for (char c : map.keySet()) {
                if (map.get(c) % 2 != 0) {
                    numOfOddOcc++;
                }
            }

            if (numOfOddOcc > k + 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
        in.close();
    }
}