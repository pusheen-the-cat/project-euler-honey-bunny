package projecteuler.honeybunny;

import projecteuler.honeybunny.util.PrimeGenerator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Largest prime factor
 *
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    private static final Long TARGET = 600851475143L;

    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        // firstMethod(primeGenerator);
        iteratorMethod(primeGenerator);
    }

    private static void iteratorMethod(PrimeGenerator primeGenerator) {
        Iterator<Long> iterator = primeGenerator.primeIterator();

        long currentPrime = 0l;
        long unfactoredValue = TARGET;
        while (unfactoredValue > 1) {
            currentPrime = iterator.next();
            unfactoredValue = factorOutPrimeNumber(unfactoredValue, currentPrime);
        }

        System.out.println("Iterator solution: " + currentPrime);
    }

    private static long factorOutPrimeNumber(long unfactoredValue, long primeNumber) {
        while (unfactoredValue % primeNumber == 0) {
            unfactoredValue = unfactoredValue / primeNumber;
        }
        return unfactoredValue;
    }

    private static void firstMethod(PrimeGenerator primeGenerator) {
        LinkedList<Long> primeNumbers =  primeGenerator.primesUpTo((long) Math.sqrt(600851475143L));

        for (Iterator<Long> it = primeNumbers.descendingIterator(); it.hasNext(); ) {
            Long topPrime = it.next();

            if (TARGET % topPrime == 0) {
                System.out.println("Largest Prime Factor: " + topPrime);
                return;
            }
        }
    }
}
