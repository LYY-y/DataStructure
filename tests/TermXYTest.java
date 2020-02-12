import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TermXYTest {
    TermXY termXY;

    @Before
    public void setUp() throws Exception {
        termXY=new TermXY("2x^2y^2");
    }

    @Test
    public void testToString1() {
        TermXY termXY2=new TermXY("xy");
        TermXY termXY3=new TermXY("5");
        TermXY termXY4=new TermXY("x^11y");
        TermXY termXY5=new TermXY("xy^12");
        TermXY termXY6=new TermXY("y^12");
        TermXY termXY7=new TermXY("8x^12");
        System.out.println(termXY.toString());
        System.out.println(termXY2.toString());
        System.out.println(termXY3.toString());
        System.out.println(termXY4.toString());
        System.out.println(termXY5.toString());
        System.out.println(termXY6.toString());
        System.out.println(termXY7.toString());
    }

    @Test
    public void testCompareTo() {
        TermXY termXY2=new TermXY("xy");
        TermXY termXY3=new TermXY("2x^2y^2");
        assertEquals(1,termXY.compareTo(termXY2));
        assertEquals(0,termXY.compareTo(termXY3));
    }

    @Test
    public void testEquals() {
        TermXY termXY2=new TermXY("xy");
        TermXY termXY3=new TermXY("2x^2y^2");
        assertFalse(termXY.equals(termXY2));
        assertTrue(termXY.equals(termXY3));
    }
}