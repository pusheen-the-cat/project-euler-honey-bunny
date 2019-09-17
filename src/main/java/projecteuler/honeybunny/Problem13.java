package projecteuler.honeybunny;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

/**
 * Large sum
 *
 * Problem 13
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 *
 * 37107287533902102798797998220837590246510135740250
 * 46376937677490009712648124896970078050417018260538
 * 74324986199524741059474233309513058123726617309629
 * 91942213363574161572522430563301811072406154908250
 * 23067588207539346171171980310421047513778063246676
 * 89261670696623633820136378418383684178734361726757
 * ...
 */
public class Problem13 {
    public static void main(String[] args) throws Exception {
        BigInteger sum = Files.lines(Path.of("src/main/java/projecteuler/honeybunny/resources/Problem13Input"))
                .map(BigInteger::new)
                .collect(Collectors.reducing(BigInteger.ZERO, BigInteger::add));

        String firstTen = sum.toString().substring(0, 10);
        System.out.println("First 10 digits: " + firstTen);
    }
}
