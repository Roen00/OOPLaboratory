package zelek.rafal.functional.common;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final public class ArgumentsParser {
    private static ArgumentsParser ourInstance = new ArgumentsParser();
    public BiFunction<List<Integer>, Integer, Optional<List<Integer>>> validateArgumentsLength = (args, expectedLength) -> {
        if (args.size() == expectedLength) {
            return Optional.of(args);
        } else {
            return Optional.empty();
        }
    };

    private ArgumentsParser() {
    }

    public static ArgumentsParser getInstance() {
        return ourInstance;
    }

    public Collector<Integer, ?, List<Integer>> indexing() {
        return Collector.of(
                LinkedList::new,
                List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }
        );
    }

    private <T> Optional<Stream<T>> invert(Stream<Optional<T>> stream) {
        try {
            return Optional.of(
                    stream.map(Optional::get)
                            .collect(Collectors.toList())
                            .stream());
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public Optional<Stream<Integer>> integerInput(String[] args) {
        final List<String> input = Arrays.asList(args);
        final Stream<Optional<Integer>> parsedInput = input.stream().map(this::parseStringToInteger);
        final List<Optional<Integer>> collected = parsedInput.collect(Collectors.toList());
        return invert(collected.stream());
    }

    public Optional<Integer> parseStringToInteger(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}


