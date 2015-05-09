package zelek.rafal.zadanie;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Laboratory1 {

    public final Optional<QuadraticEquation> result;

    private final Function<Stream<Integer>, Optional<QuadraticEquation>> createQuadraticEquation = (parameters) -> {
        if (parameters.count() == 3) {
            final Iterator<Integer> it = parameters.iterator();
            return QuadraticEquation.apply(it.next(), it.next(), it.next());
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
