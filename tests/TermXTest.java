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

    @Ignore
    @Test
    public void testEquals() {
    }

    @Ignore
    @Test
    public void testCompareTo() {
    }

    @Ignore
    @Test
    public void testAdd() {
    }

    @Ignore
    @Test
    public void testRemoveable() {
    }
}