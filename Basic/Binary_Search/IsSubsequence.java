import java.util.*;

public class IsSubsequence {
    public static void main(String[] args) {
        String[] strs = { "abc", "hgc", "axc", "dc", "ret" };
        String t = "ahbgdc";

        Map<Character, List<Integer>> map = new HashMap<>();

        // preprocessing the string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        List<Boolean> res = new ArrayList<>();

        for (String s : strs) {
            int prevIdx = -1;
            boolean ans = true;
            for (char ch : s.toCharArray()) {
                if (!map.containsKey(ch)) {
                    ans = false;
                    break;
                }

                List<Integer> indices = map.get(ch);
                int nextIdx = binarySearch(indices, prevIdx);
                if (nextIdx == -1) {
                    ans = false;
                    break;
                }
                prevIdx = nextIdx;
            }
            res.add(ans);
        }

        for (boolean ans : res) {
            System.out.print(ans + " ");
        }
    }

    private static int binarySearch(List<Integer> indices, int prevIdx) {
        int lo = 0, hi = indices.size() - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (indices.get(mid) > prevIdx) {
                hi = mid - 1;
                ans = indices.get(mid);
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
