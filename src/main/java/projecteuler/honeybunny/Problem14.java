package projecteuler.honeybunny;

import java.time.Instant;

/**
 * Longest Collatz sequence
 * <p>
 * Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * Implementation Note: Attempting to write this with basic HashMap memoization results in a slower runtime.
 */
public class Problem14 {
    public static void main(String[] args) {
        Instant startTime = Instant.now();

        long bestStart = 0;
        long bestTotalInSequence = 0;

        for (long i = 1; i < 1_000_000; i++) {
            long currentTotalInSequence = getTotalInSeqRecursive(i);
            if (currentTotalInSequence > bestTotalInSequence) {
                bestStart = i;
                bestTotalInSequence = currentTotalInSequence;
            }
        }

        System.out.println("Best Starting number: " + bestStart + " with total: " + bestTotalInSequence);
        System.out.println("time in ms: " + (Instant.now().toEpochMilli() - startTime.toEpochMilli()));
    }

    /**
     * Recursive solution.
     */
    public static long getTotalInSeqRecursive(long start) {
        if (start == 1) {
            return 1;
        }

        long total = 0;
        if (start % 2 == 0) {
            total = getTotalInSeqRecursive(start / 2) + 1;
        } else { // odd
            total = getTotalInSeqRecursive((3 * start) + 1) + 1;
        }

        return total;
    }

    /**
     * Unrolled recursive solution. A little faster (~200ms).
     */
    public static long getTotalInSeqUnrolled(long start) {
        if (start == 1) {
            return 1;
        }

        long curStart = start;
        long numInSequence = 1;

        while (curStart != 1) {
            numInSequence += 1;
            if (curStart % 2 == 0) {
                curStart = curStart / 2;
            } else { // odd
                curStart = (3 * curStart) + 1;
            }
        }

        return numInSequence;
    }
}
