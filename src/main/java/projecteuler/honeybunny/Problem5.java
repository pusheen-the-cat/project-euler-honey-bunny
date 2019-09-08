package projecteuler.honeybunny;

import projecteuler.honeybunny.util.PrimeGenerator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Smallest multiple
 * <p>
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {
    /**
     * Methodology:
     * 1: Do prime factorization
     * 2: Add all prime factors that are not already
     *    present in the list (duplicates are required)
     * 3: Result is the product of all numbers in list
     *
     * Ex: 1-6.
     * 1. 1=1, 2=2, 3=3, 4=2*2, 5=5, 6=2*3
     * 2. [2,2,3,5]
     * 3. 2*2*3*5 = 60
     */
    public static void main(String[] args) {
        // Map is primes to max factorization number.
        // Ex: Take 1-6 example above. The map would contain the following:
        // { {2->2}, {3->1}, {5->1} }
        Map<Long, Integer> factors = new HashMap<>();
        List<Long> primes = new PrimeGenerator().primesUpTo(20L);
        for (int i = 1; i <= 20; i++) {
            Map<Long, Integer> currFactors = findFactors(primes, i);
            for (Map.Entry<Long, Integer> e : currFactors.entrySet()) {
                factors.put(e.getKey(),
                        Math.max(e.getValue(), factors.getOrDefault(e.getKey(), 0)));
            }
        }

        // System.out.println("Map: " + factors.toString());
        System.out.println("Result for numbers 1-20 is " +
                factors.entrySet()
                        .stream()
                        .map(e -> (long) Math.pow(e.getKey(), e.getValue()))
                        .collect(Collectors.reducing(1L, (i, j) -> i * j)));


    }

    private static Map<Long, Integer> findFactors(List<Long> primes, long i) {
        Map<Long, Integer> result = new HashMap<>();
        for (long prime : primes) {
            if (i == 1) {
                return result;
            }
            while (i % prime == 0) {
                result.put(prime, result.getOrDefault(prime, 0) + 1);
                i = i / prime;
            }
        }
        return result;
    }
}
