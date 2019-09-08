package projecteuler.honeybunny;

import projecteuler.honeybunny.util.PalindromeHelper;

/**
 * Largest palindrome product
 *
 * Problem 4
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
    public static void main(String[] args) {
        PalindromeHelper helper = new PalindromeHelper();

        int largest = 0;
        for (int i = 999; i > 0; i--) {
            largest = doInnerLoop(helper, largest, i);
        }
        printResult(largest);
    }

    /**
     * Checks if any products, which are palindromes, are
     * larger than the largest value found so far.
     *
     * @return the largest product found so far, which may
     * be the largestSoFar passed in.
     */
    private static int doInnerLoop(PalindromeHelper helper, int largestSoFar, int i) {
        for (int j = 999; j > 0; j--) {
            int product = i * j;
            if (product < largestSoFar) {
                return largestSoFar;
            } else if (helper.isPalindrome(product)) {
                return product;
            }
        }
        return largestSoFar;
    }

    private static void printResult(int product) {
        System.out.println("Largest Palindrome Product: " + product);
    }
}
