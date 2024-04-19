import java.util.Scanner;

public class Target_Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                String line = in.nextLine();
                for (int j = 0; j < 10; j++) {
                    char inputChar = line.charAt(j);
                    if (inputChar == 'X') {
                        if (i == 0 || j == 0 || i == 9 || j == 9)
                            sum += 1;
                        else if (i == 1 || j == 1 || i == 8 || j == 8)
                            sum += 2;
                        else if (i == 2 || j == 2 || i == 7 || j == 7)
                            sum += 3;
                        else if (i == 3 || j == 3 || i == 6 || j == 6)
                            sum += 4;
                        else if (i == 4 || j == 4 || i == 5 || j == 5)
                            sum += 5;
                    }
                }
            }
            System.out.println(sum);
        }
        in.close();
    }
}
