import java.util.HashMap;
import java.util.Scanner;

public class Update_Queries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            String s = in.next();

            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextInt();
            }

            String c = in.next();

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                map.put(c.charAt(i), map.getOrDefault(c.charAt(i), 0) + 1);
            }

            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < m; i++) {
                freq.put(arr[i] - 1, map.getOrDefault(arr[i] - 1, 0) + 1);
            }

            char[] res = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (freq.containsKey(i)) {
                    int val = freq.get(i);
                    if (val > 1) {
                        int temp = val - 1;
                        for (int j = 25; j >= 0; j--) {
                            char ch = (char) (j + 'a');
                            if (map.containsKey(ch)) {
                                int mapval = map.get(ch);
                                if (mapval > 0) {
                                    if (mapval >= temp) {
                                        map.put(ch, mapval - temp);
                                        break;
                                    } else {
                                        map.put(ch, temp - mapval);
                                        temp -= mapval;
                                        continue;
                                    }
                                }
                            }
                        }
                    } else if (val == 1) {
                        for (int j = 0; j < 26; j++) {
                            char ch = (char) (j + 'a');
                            if (map.containsKey(ch)) {
                                int mapval = map.get(ch);
                                if (mapval > 0) {
                                    res[i] = ch;
                                    map.put(ch, mapval - 1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(new String(res));
        }
        in.close();
    }
}
