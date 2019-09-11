package projecteuler.honeybunny;

import projecteuler.honeybunny.util.PrimeGenerator;

import java.util.function.Function;

/**
 * Summation of primes
 *
 * Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class Problem10 {
    public static void main(String[] args) {
        long sum = PrimeGenerator.get()
                .primesUpTo(2_000_000L)
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        System.out.println("Sum: " + sum);
    }
}
