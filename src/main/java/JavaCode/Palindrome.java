package JavaCode;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        String sWithoutSpacesAndPunctuation = s.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();

        int left = 0;
        int right = sWithoutSpacesAndPunctuation.length() - 1;

        while (left < right) {
            if (sWithoutSpacesAndPunctuation.charAt(left) != sWithoutSpacesAndPunctuation.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
