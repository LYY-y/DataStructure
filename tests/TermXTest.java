import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TermXTest {
    TermX termX;
    @Before
    public void setUp() throws Exception {
        termX=new TermX("15x^3");
    }


    @Test
    public void testToString() {
        TermX termX1=new TermX("-8");
        TermX termX2=new TermX("5");
        TermX termX3=new TermX("-x");
        TermX termX4=new TermX("-x^5");
        System.out.println(termX.toString());
        System.out.println(termX1.toString());
        System.out.println(termX2.toString());
        System.out.println(termX3.toString());
        System.out.println(termX4.toString());
    }


    @Test
    public void testEquals() {
        TermX termX2=new TermX("15x^3");
        TermX termX3=new TermX("x");
        assertTrue(termX.equals(termX2));
        assertFalse(termX.equals(termX3));
    }

    @Test
    public void testCompareTo() {
        TermX termX2=new TermX("15x^3");
        TermX termX3=new TermX("x");
        assertEquals(0,termX.compareTo(termX2));
        assertEquals(1,termX.compareTo(termX3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd() {
        TermX termX2=new TermX("10x^2");
        termX.add(termX2);
        System.out.print(termX);
    }

    @Ignore
    @Test
    public void testRemoveable() {
        assertTrue(new TermX("0x^5").removeable());
    }
}