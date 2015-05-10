package zelek.rafal.exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

final class QuadraticEquation {
    public final int a;
    public final int b;
    public final int c;
    public final Double delta;
    public final List<Double> square;

    private QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        delta = calculateDelta(a, b, c);
        square = calculateSquare(delta, a, b);
    }

    public static Optional<QuadraticEquation> apply(int a, int b, int c) {
        return a == 0 ? Optional.empty() : Optional.of(new QuadraticEquation(a, b, c));
    }

    private double calculateDelta(int a, int b, int c) {
        return b * b - 4 * a * c;
    }

    private List<Double> calculateSquare(double delta, int a, int b) {
        if (delta == 0)
            return Arrays.asList((-b) / (2d * a));
        else if (delta > 0)
            return Arrays.asList((-b - Math.sqrt(delta)) / (2 * a), (-b + Math.sqrt(delta)) / (2 * a));
        else
            return Arrays.asList();
    }
}
