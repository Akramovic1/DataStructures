package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    SimpleCalculator calc = new SimpleCalculator();

    @Test
    void addition() {
        assertEquals(6,calc.addition(3,3));
        assertEquals(7,calc.addition(4,3));
        assertEquals(8,calc.addition(5,3));
        assertEquals(9,calc.addition(6,3));
        assertEquals(5,calc.addition(2,3));
        assertEquals(10,calc.addition(1,9));
        assertEquals(24,calc.addition(12,12));
        assertEquals(55,calc.addition(2,53));
    }
    @Test
    void division() {
        assertEquals(5,calc.division(20,4));
        assertEquals(6 , calc.division(30,5));
        assertEquals(9 , calc.division(45,5));
        assertEquals(29 , calc.division(261,9));
        assertEquals(71 , calc.division(355,5));
        assertEquals(36 , calc.division(108,3));
        assertThrows(RuntimeException.class,()->calc.division(2,0));
    }
}