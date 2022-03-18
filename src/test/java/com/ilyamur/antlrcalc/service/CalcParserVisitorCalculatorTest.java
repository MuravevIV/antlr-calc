package com.ilyamur.antlrcalc.service;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalcParserVisitorCalculatorTest {

    private static final double DELTA = 1e-15;

    @InjectMocks
    private CalcParserVisitorCalculator calculator;

    @Test
    public void testCalculateDoubleLiteral() {
        assertEquals(1.1, calculator.calculate("1.1"));
    }

    @Test
    public void testCalculateLongDoubleLiteral() {
        assertEquals(123.4, calculator.calculate("123.4"));
    }

    @Test
    public void testCalculateDoubleLiteralStartingWithZero() {
        assertEquals(0.1, calculator.calculate("0.1"));
    }

    @Test
    public void testCalculateNegativeDoubleLiteral() {
        assertEquals(-1.1, calculator.calculate("-1.1"));
    }

    @Test
    public void testCalculateNegativeDoubleLiteralStartingWithZero() {
        assertEquals(-0.1, calculator.calculate("-0.1"));
    }

    @Test
    public void testCalculateWrongDoubleLiteral() {
        assertThrows(ParseCancellationException.class, () -> {
            calculator.calculate("01.1");
        });
    }

    @Test
    public void testCalculateSubtractionWhenNoSpaces() {
        assertEquals(2.2, calculator.calculate("3.3-1.1"), DELTA);
    }

    @Test
    public void testCalculateSubtractionWhenAmbiguousMinus() {
        assertEquals(2.2, calculator.calculate("3.3 -1.1"), DELTA);
    }

    @Test
    public void testCalculateParentheses() {
        assertEquals(1.1, calculator.calculate("(1.1)"));
    }

    @Test
    public void testCalculateMultiplicationAndDivision() {
        assertEquals(6.6, calculator.calculate("2.2 * 3"), DELTA);
        assertEquals(2.2, calculator.calculate("6.6 / 3"), DELTA);
    }

    @Test
    public void testCalculateAdditionAndSubtraction() {
        assertEquals(5.5, calculator.calculate("3.3 + 2.2"), DELTA);
        assertEquals(1.1, calculator.calculate("3.3 - 2.2"), DELTA);
    }

    @Test
    public void testCalculateAllRules() {
        assertEquals(20.0, calculator.calculate("3 * (4 + 5) - 7"));
    }

    @Test
    public void testCalculateWhenUnrecognizedToken() {
        assertThrows(ParseCancellationException.class, () -> {
            calculator.calculate("a");
        });
    }

    @Test
    public void testCalculateWhenOrphanToken() {
        assertThrows(ParseCancellationException.class, () -> {
            calculator.calculate("+");
        });
    }
}
