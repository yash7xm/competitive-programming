public class VowelString {
    public static void main(String[] args) {

    }

    public static String findString(int input1, String[] input2) {
        StringBuilder res = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < input1; i++) {
            String str = input2[i];
            if (!str.isEmpty()) {
                if (vowels.indexOf(str.charAt(0)) != -1 && vowels.indexOf(str.charAt(str.length() - 1)) != -1) {
                    res.append(str);
                }
            }
        }

        if (res.length() == 0) {
            res.append("no matches found");
        }

        return res.toString().toLowerCase();
    }
}
