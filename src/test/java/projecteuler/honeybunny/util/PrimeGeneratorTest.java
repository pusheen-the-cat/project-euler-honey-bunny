package projecteuler.honeybunny.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PrimeGeneratorTest {

    private PrimeGenerator primeGenerator;

    @BeforeEach
    public void setup() {
        primeGenerator = new PrimeGenerator();
    }

    @Test
    public void testPrimeGenerator() {
        List<Long> expected =
                List.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L,
                        67L, 71L, 73L, 79L, 83L, 89L, 97L, 101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L,
                        139L, 149L, 151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L, 197L, 199L);

        List<Long> result = primeGenerator.primesUpTo(200);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPrimeGenerator_MaxIsPrime() {
        List<Long> expected =
                List.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L,
                        67L, 71L, 73L, 79L, 83L, 89L, 97L, 101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L,
                        139L, 149L, 151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L, 197L, 199L);

        List<Long> result = primeGenerator.primesUpTo(199);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPrimeGenerator_ZeroMax() {
        List<Integer> expected = List.of();

        List<Long> result = primeGenerator.primesUpTo(0);
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void testPrimeGenerator_iterator() {
        List<Long> expected =
                List.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L,
                        67L, 71L, 73L, 79L, 83L, 89L, 97L, 101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L,
                        139L, 149L, 151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L, 197L, 199L);

        Iterator<Long> result = primeGenerator.primeIterator();
        Iterator<Long> expectedIterator = expected.iterator();

        while (expectedIterator.hasNext()) {
            Assertions.assertTrue(result.hasNext(), "Prime iterator hasNext() should always return true.");
            Assertions.assertEquals(expectedIterator.next(), result.next());
        }

        Assertions.assertTrue(result.hasNext(), "Prime iterator hasNext() should always return true.");
    }
}