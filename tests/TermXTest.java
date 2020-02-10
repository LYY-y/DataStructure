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
    public void toString1() {
        TermX termX1=new TermX("x");
        TermX termX2=new TermX("5x");
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
    public void equals1() {
    }

    @Ignore
    @Test
    public void compareTo() {
    }

    @Ignore
    @Test
    public void add() {
    }

    @Ignore
    @Test
    public void removeable() {
    }
}