package zelek.rafal.functional.exercise1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LaboratoryTest {
    @Test
    public void labResultShouldContainsQuadraticEquationWithTwoSquares() {
        //Given array of quadratic equation parameters
        String[] input = {"2", "-3", "1"};
        //When I create the Laboratory
        Laboratory lab1 = new Laboratory(input);

        //Then I expect 0.5 and 1 squares
        List<Double> expected = Arrays.asList(0.5d, 1d);
        assertThat(lab1.result.get().square, is(expected));
        //And delta greater than zero
        assertTrue(lab1.result.get().delta > 0);
    }

    @Test
    public void labResultShouldContainsEmptyQuadraticEquationForInputArgumentsLowerThan3() {
        //Given array of quadratic equation parameters
        String[] input = {"2", "-3"};
        //When I create the Laboratory
        Laboratory lab1 = new Laboratory(input);
        //Then I expect empty quadratic equation
        assertThat(lab1.result, is(Optional.empty()));
    }

    @Test
    public void labResultShouldContainsEmptyQuadraticEquationForInputArgumentsGreaterThan3() {
        //Given array of quadratic equation parameters
        String[] input = {"2", "-3", "4", "5"};
        //When I create the Laboratory
        Laboratory lab1 = new Laboratory(input);
        //Then I expect empty quadratic equation
        assertThat(lab1.result, is(Optional.empty()));
    }

    @Test
    public void labResultShouldContainsEmptyQuadraticEquationForInvalidInputArguments() {
        //Given array of quadratic equation parameters
        String[] input = {"test", "-3", "4"};
        //When I create the Laboratory
        Laboratory lab1 = new Laboratory(input);
        //Then I expect empty quadratic equation
        assertThat(lab1.result, is(Optional.empty()));
    }
}
