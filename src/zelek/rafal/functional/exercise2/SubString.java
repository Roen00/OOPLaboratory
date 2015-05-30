package zelek.rafal.functional.exercise2;

import java.util.Optional;

final public class SubString {
    public final String result;

    private SubString(String text, int from, int to) {
        this.result = text.substring(from, to);
    }

    private static boolean checkParameters(String text, int from, int to) {
        if (from < 0) {
            return false;
        }
        if (to < from) {
            return false;
        }
        if (from > to) {
            return false;
        }
        if (to > text.length() - 1) {
            return false;
        }
        return true;
    }

    public static Optional<SubString> apply(String text, int from, int to) {
        if (checkParameters(text, from, to)) {
            return Optional.of(new SubString(text, from, to));
        } else {
            return Optional.empty();
        }
    }
}
