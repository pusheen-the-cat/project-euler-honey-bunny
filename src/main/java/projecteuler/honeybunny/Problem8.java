package projecteuler.honeybunny;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Largest product in a series
 *
 * Problem 8
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 *
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 *
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 */
public class Problem8 {
    public static void main(String[] args) throws Exception {
        String input = Files.lines(Path.of("src/main/java/projecteuler/honeybunny/resources/Problem8Input"))
                .collect(Collectors.joining(""));

        // 0 creates a 0 product. Only check against subsets where 0 is not found
        String[] zeroDelimitedValues = input.split("0");

        long best = Arrays.stream(zeroDelimitedValues)
                .filter(s -> s.length() >= 13) // If the size is less than 13, then the product would have been 0
                .mapToLong(Problem8::getBestProductOf13)
                .max()
                .getAsLong();

        System.out.println("Best Product: " + best);
    }

    /**
     * Sliding window implementation where we divide out the number that
     * falls out of the window and multiple the new number to create the next segment.
     */
    private static long getBestProductOf13(String input) {
        List<Integer> ints = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        long curProduct = getProductOfFirst13(ints);
        long bestSoFar = curProduct;

        for (int tail = 0, next = 13; next < ints.size(); next++, tail++) {
            curProduct = (curProduct / ints.get(tail)) * ints.get(next);
            if (curProduct > bestSoFar) {
                bestSoFar = curProduct;
            }
        }
        return bestSoFar;
    }

    private static long getProductOfFirst13(List<Integer> input) {
        long product = 1;
        for (int i = 0; i < 13; i++) {
            product = product * input.get(i);
        }
        return product;
    }
}
