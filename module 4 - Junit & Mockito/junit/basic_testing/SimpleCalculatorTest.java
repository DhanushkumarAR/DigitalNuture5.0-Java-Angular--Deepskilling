package junit.basic_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    @Test
    void testAdd() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        assertNotEquals(6, calculator.add(2, 3), "2 + 3 should not equal 6");
    }

    @Test
    void testTrueFalse() {
        assertTrue(5 > 0, "5 should be greater than 0");
        assertFalse(5 < 0, "5 should not be less than 0");
    }

    @Test
    void testNullNotNull() {
        String nullString = null;
        String notNullString = "Hello";

        assertNull(nullString, "String should be null");
        assertNotNull(notNullString, "String should not be null");
    }
}
