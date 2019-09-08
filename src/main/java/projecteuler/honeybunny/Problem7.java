package projecteuler.honeybunny;

import projecteuler.honeybunny.util.PrimeGenerator;

import java.util.Iterator;

/**
 * 10001st prime
 * Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
public class Problem7 {
    public static void main(String[] args) {
        Iterator<Long> primeIterator = new PrimeGenerator().primeIterator();
        for (int i = 0; i < 10000; i++) {
            primeIterator.next();
        }

        System.out.println("10001st prime: " + primeIterator.next());
    }
}
