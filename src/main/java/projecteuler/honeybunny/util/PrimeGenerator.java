package projecteuler.honeybunny.util;

import java.util.LinkedList;
import java.util.List;

public class PrimeGenerator {
    public LinkedList<Long> primesUpTo(long max) {
        LinkedList<Long> existingPrimes = new LinkedList<>();

        if(max < 2) {
            return existingPrimes;
        }
        existingPrimes.add(2L);

        for (long i = 3; i <= max; i++) {
            if (isPrime(existingPrimes, i)) {
                existingPrimes.add(i);
            }
        }

        return existingPrimes;
    }

    private boolean isPrime(List<Long> existingPrimes, long numberToCheck) {
        double sqrt = Math.sqrt(numberToCheck);
        for (Long existingPrime : existingPrimes) {
            if (existingPrime > (int) sqrt) {
                return true;
            }
            if (numberToCheck % existingPrime == 0) {
                return false;
            }
        }
        // Cannot be reached
        return true;
    }
}
