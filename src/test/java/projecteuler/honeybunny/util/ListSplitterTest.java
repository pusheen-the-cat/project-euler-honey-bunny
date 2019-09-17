package projecteuler.honeybunny.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListSplitterTest {

    private ListSplitter<Character> helper;

    @BeforeEach
    void setup() {
        helper = new ListSplitter<>();
    }

    @ParameterizedTest
    @MethodSource("getMethodSource")
    void test_splitList(TestCase testCase) {
        assertEquals(testCase.expected, helper.splitList(testCase.list, testCase.c));
    }

    private static Stream<TestCase> getMethodSource() {
        return Stream.of(
                new TestCase(null, List.of(List.of())),
                new TestCase(List.of('a', 'b', 'c', 'a', 'b', 'c', 'b'),
                        List.of(
                                List.of(),
                                List.of('b', 'c'),
                                List.of('b', 'c', 'b'))),
                new TestCase(List.of(), List.of(List.of())),
                new TestCase(List.of('a', 'a'), List.of(List.of(), List.of(), List.of()))
        );
    }

    private static class TestCase {
        List<Character> list;
        char c;
        List<List<Character>> expected;

        TestCase(List<Character> list, List<List<Character>> expected) {
            this.list = list;
            this.c = 'a';
            this.expected = expected;
        }
    }

}