package zelek.rafal.common;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class ArgumentsParser {
    private static ArgumentsParser ourInstance = new ArgumentsParser();

    private ArgumentsParser() {
    }

    public static ArgumentsParser getInstance() {
        return ourInstance;
    }

    public Stream<Integer> integerInput(String[] args) {
        final Stream<String> input = Arrays.stream(args);
        final Stream<Optional<Integer>> parsedInput = input.map(this::parseStringToInteger);
        return parsedInput.filter(Optional::isPresent).map(Optional::get);
    }

    private Optional<Integer> parseStringToInteger(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
