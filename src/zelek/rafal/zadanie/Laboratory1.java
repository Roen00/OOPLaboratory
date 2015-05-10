package zelek.rafal.zadanie;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Laboratory1 {

    public final Optional<QuadraticEquation> result;

    private final Function<Stream<Integer>, Optional<QuadraticEquation>> createQuadraticEquation = (parameters) -> {
        final List<Integer> p = parameters.collect(Collectors.toList());
        if (p.size() == 3) {
            return QuadraticEquation.apply(p.get(0), p.get(1), p.get(2));
        } else {
            return Optional.empty();
        }
    };

    public Laboratory1(String[] args) {
        final Stream<String> input = Arrays.stream(args);
        final Stream<Optional<Integer>> parsedInput = input.map(this::parseStringToInteger);
        final Stream<Integer> collectedInput = parsedInput.filter(Optional::isPresent).map(Optional::get);
        result = createQuadraticEquation.apply(collectedInput);
    }

    private Optional<Integer> parseStringToInteger(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
