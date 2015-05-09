package zelek.rafal.zadanie;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QuadraticEquationTest {
    @Test
    public void quadraticEquationShouldBeEmptyWhenAEqualsToZero() {
        //Given quadratic equation parameters
        int a = 0;
        int b = 0;
        int c = 0;
        //When I create the quadraticEquation
        Optional<QuadraticEquation> quadraticEquation = QuadraticEquation.apply(a, b, c);
        //Then I expect empty quadratic equation object
        assertFalse(quadraticEquation.isPresent());
    }

    @Test
    public void quadraticEquationShouldNotBeEmptyWhenAIsGreaterThanZero() {
        //Given quadratic equation parameters
        int a = 1;
        int b = 0;
        int c = 0;
        //When I create the quadraticEquation
        Optional<QuadraticEquation> quadraticEquation = QuadraticEquation.apply(a, b, c);
        //Then I expect not empty quadratic equation object
        assertTrue(quadraticEquation.isPresent());
    }

    @Test
    public void quadraticEquationShouldNotBeEmptyWhenAIsLowerThanZero() {
        //Given quadratic equation parameters
        int a = -1;
        int b = 0;
        int c = 0;
        //When I create the quadraticEquation
        Optional<QuadraticEquation> quadraticEquation = QuadraticEquation.apply(a, b, c);
        //Then I expect not empty quadratic equation object
        assertTrue(quadraticEquation.isPresent());
    }

    @Test
    public void squareShouldContainsTheTwoResults() {
        //Given quadratic equation parameters
        int a = 2;
        int b = -3;
        int c = 1;
        //When I create the quadraticEquation
        Optional<QuadraticEquation> quadraticEquation = QuadraticEquation.apply(a, b, c);
        //And when I get the square
        List<Double> result = quadraticEquation.get().square;
        //Then I expect square equals to 0.5 and 1
        List<Double> expected = Arrays.asList(0.5d, 1d);
        assertThat(result, is(expected));
    }

    @Test
    public void deltaShouldBeProperCalculated() {
        //Given quadratic equation parameters
        int a = 2;
        int b = -3;
        int c = 1;
        //When I create quadraticEquation
        Optional<QuadraticEquation> quadraticEquation = QuadraticEquation.apply(a, b, c);
        //Then I expect not empty quadratic equation object
        double delta = quadraticEquation.get().delta;
        double expectedDelta = 1d;
        assertThat(delta, is(expectedDelta));
    }
}
