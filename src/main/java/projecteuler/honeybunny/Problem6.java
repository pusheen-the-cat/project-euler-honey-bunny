package projecteuler.honeybunny;

import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Sum square difference
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first
 * one hundred natural numbers and the square of the sum.
 */
public class Problem6 {
    public static void main(String[] args) {
        long sumOfSquares = sumOfSquares(100);
        long squareOfSums = squareOfSums(100);

        System.out.println("Difference: " + Math.abs(squareOfSums - sumOfSquares));
    }

    private static long sumOfSquares(long max) {
        return LongStream.rangeClosed(1L, max)
                .map(i -> (long) Math.pow(i, 2))
                .sum();
    }

    private static long squareOfSums(long max) {
        // Gauss's method of summing sequential numbers
        long sums = (max + 1) * (max / 2);
        return (long) Math.pow(sums, 2);
    }
}
