package projecteuler.honeybunny.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeHelperTest {

    private PalindromeHelper helper;

    @BeforeEach
    void setup() {
        helper = new PalindromeHelper();
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "a", "aba", "abba", "abcba", "abccba" })
    void isPalindromeString_true(String value) {
        Assertions.assertTrue(helper.isPalindrome(value));
    }

    @ParameterizedTest
    @ValueSource(strings = { "ab", "abab", "taco cat" })
    void isPalindromeString_false(String value) {
        Assertions.assertFalse(helper.isPalindrome(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 11, 121, 1221, 12321, 123321 })
    void isPalindromeInt_true(int value) {
        Assertions.assertTrue(helper.isPalindrome(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 12, 112, 1212, 1337, 1233221 })
    void isPalindromeInt_false(int value) {
        Assertions.assertFalse(helper.isPalindrome(value));
    }

    @ParameterizedTest
    @ValueSource(longs = { 0L, 1L, 11L, 121L, 1221L, 12321L, 123321L })
    void isPalindromeLong_true(long value) {
        Assertions.assertTrue(helper.isPalindrome(value));
    }

    @ParameterizedTest
    @ValueSource(longs = { 12L, 112L, 1212L, 1337L, 1233221L })
    void isPalindromeLong_false(long value) {
        Assertions.assertFalse(helper.isPalindrome(value));
    }
}