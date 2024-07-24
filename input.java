public class input {
    public static void main(String[] args) {
        System.out.println(findKey(2610, 2359, 1784));
    }

    public static int findKey(int input1, int input2, int input3) {
        int key = 0;
        int a = 0;
        while (input1 > 0) {
            a = input1 % 10;
            input1 /= 10;
        }

        int[] b = new int[4];
        int i = 3;
        while (input2 > 0) {
            b[i] = input2 % 10;
            i--;
            input2 /= 10;
        }

        int c = 0;
        while (input3 > 0) {
            c = Math.max(c, input3 % 10);
            input3 /= 10;
        }

        key = (a * b[1]) - c;

        return key;
    }
}
