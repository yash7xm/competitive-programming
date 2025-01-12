import java.util.Scanner;

public class GridGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int v = 0, h = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                System.out.println("1" + " " + (h + 1));
                h = (h + 2) % 4;
            } else {
                System.out.println("2" + " " + (v + 1));
                v = (v + 1) % 4;
            }
        }
        in.close();
    }
}
