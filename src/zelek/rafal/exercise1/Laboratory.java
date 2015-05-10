package zelek.rafal.exercise1;

import zelek.rafal.common.ArgumentsParser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final public class Laboratory {

    public final Optional<QuadraticEquation> result;

    private final Function<Stream<Integer>, Optional<QuadraticEquation>> createQuadraticEquation = (parameters) -> {
        final List<Integer> p = parameters.collect(Collectors.toList());
        if (p.size() == 3) {
            return QuadraticEquation.apply(p.get(0), p.get(1), p.get(2));
        } else {
            return Optional.empty();
        }
    };

    public Laboratory(String[] args) {
        result = createQuadraticEquation.apply(ArgumentsParser.getInstance().integerInput(args));
    }


}
