package StringCalculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void sumsEmptyStringTo0(){
        assertEquals(StringCalculator.add(""),0);
    }

    @Test
    public void sumsSingleNumberToItself(){
        assertEquals(StringCalculator.add("10"),10);
    }

    @Test
    public void sumsNumbersSeparatedByComma(){
        assertEquals(StringCalculator.add("1,6"),7);
        assertEquals(StringCalculator.add("1,2,4,10"),17);
    }
    @Test
    public void sumsNumbersSeparatedByNewLine(){
        assertEquals(StringCalculator.add("1\n2,3"),6);
    }

    @Test
    public void sumsNumbersSpecialDelimiter(){
        assertEquals(StringCalculator.add("//;\n1;2;7;9;10"),29);
        assertEquals(StringCalculator.add("//,,\n1,,2,,3,,4,,5"),15);
    }

    @Test
    public void returnNegativeNumbers(){
        try {
            StringCalculator.add("-1,-2,3,-4");
            fail("Exception Expected.");
        }
        catch (RuntimeException ex){
            assertEquals("Negatives not Allowed : [-1, -2, -4]" , ex.getMessage());
        }
    }
}
