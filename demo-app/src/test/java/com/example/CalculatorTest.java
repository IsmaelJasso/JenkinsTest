package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Add two positive numbers")
    void testAdd() {
        assertThat(calc.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("Subtract returns correct result")
    void testSubtract() {
        assertThat(calc.subtract(10, 4)).isEqualTo(6);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
        "2,  3,  6",
        "0,  5,  0",
        "-2, 3, -6"
    })
    @DisplayName("Multiply parameterized")
    void testMultiply(double a, double b, double expected) {
        assertThat(calc.multiply(a, b)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Divide by zero throws ArithmeticException")
    void testDivideByZero() {
        assertThatThrownBy(() -> calc.divide(5, 0))
            .isInstanceOf(ArithmeticException.class)
            .hasMessageContaining("zero");
    }

    @Test
    @DisplayName("Divide returns correct result")
    void testDivide() {
        assertThat(calc.divide(10, 4)).isEqualTo(2.5);
    }
}
