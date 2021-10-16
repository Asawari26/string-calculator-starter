package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	
	private StringCalculator calculator;

    @Before
    public void initialize() {
        calculator = new StringCalculator();
    }


    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void numberStringShouldReturnSameNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(calculator.add("5"), 5);
    }
    
    @Test
    public void numbersCommaDelimitedShouldBeSummed() {
        assertEquals(calculator.add("1,2"), 3);
        assertEquals(calculator.add("10,15"), 25);
    }
    

    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
        assertEquals(calculator.add("1\n2"), 3);
        assertEquals(calculator.add("11\n13"), 24);
       }

       @Test
       public void threeNumbersDelimitedAnywayShouldBeSummed() {
           assertEquals(calculator.add("1,2,3"), 6);
           assertEquals(calculator.add("5\n2\n3"), 10);
    }
}
