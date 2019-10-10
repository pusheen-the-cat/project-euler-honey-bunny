package projecteuler.honeybunny;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Number letter counts
 * <p>
 * Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * <p>
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Problem17 {
    private static final String[] belowTwenty = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String hundred = "hundred";
    private static final String thousand = "thousand";
    private static final String and = "and";

    public static void main(String[] args) {
        int totalLength = IntStream.rangeClosed(1,1000)
                .mapToObj(Problem17::getString)
                .mapToInt(String::length)
                .sum();

        System.out.println(totalLength);
    }

    private static String getString(int num) {
        if (num >= 1000) {
            return belowTwenty[num / 1000] + thousand + getString(num % 1000);
        }
        if (num >= 100) {
            String hundredsPart = belowTwenty[num / 100] + hundred;
            return num % 100 == 0 ? hundredsPart :
                    hundredsPart + and + getString(num % 100);
        }
        if (num >= 20) {
            return tens[num / 10] + getString(num % 10);
        }
        return belowTwenty[num];
    }

}
