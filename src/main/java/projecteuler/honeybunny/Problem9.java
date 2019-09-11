package projecteuler.honeybunny;

import java.util.ArrayList;
import java.util.List;

/**
 * Special Pythagorean triplet
 *
 * Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
    public static void main(String[] args) {
        for (Triplet triplet : getAllCombinations()) {
            int leftSide = triplet.a * triplet.a + triplet.b * triplet.b;
            int rightSide = triplet.c * triplet.c;
            if (leftSide == rightSide) {
                System.out.println(String.format("a: %d, b: %d, c: %d", triplet.a, triplet.b, triplet.c));
                System.out.println("Product: " + (triplet.a * triplet.b * triplet.c));
            }
        }
    }

    private static List<Triplet> getAllCombinations() {
        List<Triplet> combinations = new ArrayList<>();
        // Max a is 332 because a < b < c and a + b + c == 1000
        // So if a == 332, b == 333, c == 335
        // a cannot be 333, because 333 + 334 + 335 > 1000
        for (int a = 1; a < 332; a++) {
            // b can be at most half of 1000 - a since c > b
            for (int b = a + 1; b < ((1000 - a) / 2); b++) {
                int c = 1000 - a - b;
                combinations.add(new Triplet(a, b, c));
            }
        }
        return combinations;
    }

    private static class Triplet {
        private final int a;
        private final int b;
        private final int c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
