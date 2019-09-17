package projecteuler.honeybunny.util;

import java.util.List;

public class BestProductHelper {

    /**
     * Sliding window implementation where we divide out the number that
     * falls out of the window and multiple the new number to create the next segment.
     */
    public long getBestProduct(List<Integer> input, int numberInSequence) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        long curProduct = getProductOfN(input, 0, numberInSequence);
        long bestSoFar = curProduct;

        for (int tail = 0, next = numberInSequence; next < input.size(); next++, tail++) {
            if (input.get(tail) == 0) {
                curProduct = getProductOfN(input, tail + 1, numberInSequence);
            } else {
                curProduct = (curProduct / input.get(tail)) * input.get(next);
            }

            if (curProduct > bestSoFar) {
                bestSoFar = curProduct;
            }
        }
        return bestSoFar;
    }

    private static long getProductOfN(List<Integer> input, int startIndex, int numberInSequence) {
        long product = 1;
        for (int i = startIndex; i < numberInSequence + startIndex && i < input.size(); i++) {
            product = product * input.get(i);
        }
        return product;
    }
}
