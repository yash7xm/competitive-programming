import java.util.*;

public class QuizMaster {
    static final int MAX_SMARTNESS = 100000;
    static List<List<Integer>> factors = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        precomputeFactors();

        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] smartness = new int[n];
            for (int i = 0; i < n; i++) {
                smartness[i] = sc.nextInt();
            }

            result.append(solve(n, m, smartness)).append("\n");
        }

        System.out.print(result);
        sc.close();
    }

    private static void precomputeFactors() {
        for (int i = 0; i <= MAX_SMARTNESS; i++) {
            factors.add(new ArrayList<>());
        }

        for (int i = 1; i <= MAX_SMARTNESS; i++) {
            for (int j = i; j <= MAX_SMARTNESS; j += i) {
                factors.get(j).add(i);
            }
        }
    }

    private static int solve(int n, int m, int[] smartness) {
        Arrays.sort(smartness);

        int[] frequency = new int[m + 1];
        int currCount = 0;
        int minDiff = Integer.MAX_VALUE;

        int l = 0;
        for (int r = 0; r < n; r++) {
            for (int factor : factors.get(smartness[r])) {
                if (factor > m)
                    break;
                if (frequency[factor] == 0)
                    currCount++;
                frequency[factor]++;
            }

            while (currCount == m) {
                minDiff = Math.min(minDiff, smartness[r] - smartness[l]);

                for (int factor : factors.get(smartness[l])) {
                    if (factor > m)
                        break;
                    frequency[factor]--;
                    if (frequency[factor] == 0)
                        currCount--;
                }
                l++;
            }
        }

        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}
