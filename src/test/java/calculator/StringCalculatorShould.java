package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	
	private StringCalculator calculator;
	 @Rule
	    public ExpectedException thrown = ExpectedException.none();

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
        assertEquals(25, calculator.add("10,15"));
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
       
       @Test
       public void negativeInputReturnsException() {
           thrown.expect(IllegalArgumentException.class);
           thrown.expectMessage("Negative input!");
           calculator.add("-1");
           calculator.add("-5,10\n-15");
       }

       @Test
       public void numbersGreaterThan1000AreIgnored() {
           assertEquals(calculator.add("5,12,1001"), 17);
           assertEquals(calculator.add("14124,22\n4,1214"), 26);
       }
}
