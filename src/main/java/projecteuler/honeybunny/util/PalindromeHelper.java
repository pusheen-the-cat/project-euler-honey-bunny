package projecteuler.honeybunny.util;

public class PalindromeHelper {

    public boolean isPalindrome(String value) {
        for (int i = 0; i < value.length()/2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(int value) {
        return isPalindrome(String.valueOf(value));
    }

    public boolean isPalindrome(long value) {
        return isPalindrome(String.valueOf(value));
    }
}
