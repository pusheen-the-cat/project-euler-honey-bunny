package projecteuler.honeybunny.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListSplitter<T> {
    public List<List<T>> splitList(List<T> input, T splitVal) {
        if (input == null) {
            return List.of(List.of());
        }
        List<Integer> zeroIndices = IntStream.range(0, input.size())
                .filter(i -> input.get(i).equals(splitVal))
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        List<List<T>> splitLists = new ArrayList<>();
        int start = 0;
        for (Integer end : zeroIndices) {
            splitLists.add(input.subList(start, end));
            start = end + 1;
        }
        splitLists.add(input.subList(start, input.size()));

        return splitLists;
    }
}
