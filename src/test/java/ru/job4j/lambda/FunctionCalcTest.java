package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLineFunctionThenLineResults() {
        List<Double> result = FunctionCalc.diapason(5, 12, x -> 2 * x);
        List<Double> expected = Arrays.asList(10D, 12D, 14D, 16D, 18D, 20D, 22D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionCalc.diapason(2, 9, x -> x * x);
        List<Double> expected = Arrays.asList(4D, 9D, 16D, 25D, 36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentFunctionThenExponentResults() {
        List<Double> result = FunctionCalc.diapason(2, 9, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4.0, 8.0, 16.0, 32.0, 64.0, 128.0, 256.0);
        assertThat(result, is(expected));
    }
}