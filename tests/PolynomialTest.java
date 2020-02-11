import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialTest {
    Polynomial polynomial;

    @Before
    public void setUp() throws Exception {
        polynomial=new Polynomial("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");
    }

    @Test
    public void testToString1() {
        TermX[] aterms={new TermX(-7,9),new TermX(2,7),new TermX(-9,4)};
        Polynomial polynomial2=new Polynomial(aterms);
        System.out.println(polynomial);
        System.out.println(polynomial2);
    }

    @Test
    public void testAddAll() {
        Polynomial polynomial2=new Polynomial("5+x-9x^2+x^10");
        polynomial.addAll(polynomial2);
        System.out.println(polynomial.toString());
    }

    @Test
    public void testUnion() {
        Polynomial polynomial2=new Polynomial("5+x-9x^2+x^10");
        Polynomial polynomial3=polynomial.union(polynomial2);
        System.out.print(polynomial3.toString());
    }

    @Test
    public void testEquals() {
        Polynomial polynomial2=new Polynomial("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");
        assertTrue(polynomial.equals(polynomial2));
    }
}