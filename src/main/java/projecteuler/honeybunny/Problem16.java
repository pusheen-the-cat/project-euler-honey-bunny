package projecteuler.honeybunny;

import java.math.BigInteger;

/**
 * Power digit sum
 *
 * Problem 16
 * 2^15 = 32,768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */
public class Problem16 {

    public static void main(String[] args) {
        BigInteger x = BigInteger.TWO.pow(1000);
        int result = x.toString().chars()
                .map(Character::getNumericValue)
                .sum();
        System.out.println(result);
    }
}
