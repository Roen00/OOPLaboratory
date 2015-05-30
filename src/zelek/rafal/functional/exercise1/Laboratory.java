package zelek.rafal.functional.exercise1;

import zelek.rafal.functional.common.ArgumentsParser;

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
        final ArgumentsParser parser = ArgumentsParser.getInstance();
        final Optional<Stream<Integer>> parsedArguments = parser.integerInput(args);
        final Integer expectedArgumentsLength = 3;
        final Optional<List<Integer>> validatedArguments = parsedArguments.flatMap(pa ->
                        parser.validateArgumentsLength.apply(
                                pa.collect(Collectors.toList()), expectedArgumentsLength
                        )
        );

        result = validatedArguments.flatMap(va -> createQuadraticEquation.apply(va.stream()));
    }


}
