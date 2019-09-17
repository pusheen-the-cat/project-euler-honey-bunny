package projecteuler.honeybunny.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestProductHelperTest {

    private BestProductHelper helper;

    @BeforeEach
    void setUp() {
        helper = new BestProductHelper();
    }

    @ParameterizedTest
    @MethodSource("getBestProductDataSource")
    void test_getBestProduct(TestCase testCase) {
        assertEquals(testCase.expected,
                helper.getBestProduct(testCase.list, testCase.numInSeq));
    }

    static Stream<TestCase> getBestProductDataSource() {
        return Stream.of(
                new TestCase(List.of(), 2, 0),
                new TestCase(null, 2, 0),
                new TestCase(List.of(1,2,3,9,4), 1, 9),
                new TestCase(List.of(0,2,3,9,4), 2, 36),
                new TestCase(List.of(1, 2, 3, 4, 5), 8, 1 * 2 * 3 * 4 * 5),
                new TestCase(List.of(5, 4, 9, -9, -8, 9, 7), 2, 72),
                new TestCase(List.of(5, 4, 3, 9, 0, 8, 7), 3, 3 * 9 * 4),
                new TestCase(List.of(4,5,3,0,9,9),3,4*5*3)
                );
    }

    private static class TestCase {
        List<Integer> list;
        int numInSeq;
        long expected;

        TestCase(List<Integer> list, int numInSeq, long expected) {
            this.list = list;
            this.numInSeq = numInSeq;
            this.expected = expected;
        }
    }

}