public class Parent {
    public static void main(String[] args) {
        System.out.println(findParent(1000000000));
    }

    private static int findParent(int processNumber) {
        int i = 1, j = 1;
        while (i < processNumber && i <= j) {
            int temp = i;
            while (temp-- > 0) {
                j++;
                if (j == processNumber)
                    return i;
            }
            i++;
        }
        return i;
    }
}
