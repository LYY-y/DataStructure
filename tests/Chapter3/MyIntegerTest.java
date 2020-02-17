package Chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyIntegerTest {
    MyInteger myInteger;
    @Before
    public void setUp() throws Exception {
        myInteger=new MyInteger("999");
    }

    @Test
    public void testIntValue() {
        assertEquals(999,myInteger.intValue());
    }

    @Test
    public void testToString() {
        System.out.println(myInteger.toString());
    }

    @Test
    public void testEquals() {
        MyInteger myInteger2=new MyInteger(999);
        MyInteger myInteger3=new MyInteger(10);
        assertTrue(myInteger.equals(myInteger2));
        assertFalse(myInteger.equals(myInteger3));
    }

    @Test
    public void testCompareTo() {
        MyInteger myInteger3=new MyInteger(10);
        assertEquals(1,myInteger.compareTo(myInteger3));
    }

    @Test
    public void testParseInt1() {
        assertEquals(7711,MyInteger.parseInt("7711"));
    }

    @Test
    public void testParseInt2() {
        assertEquals(-15,MyInteger.parseInt("-1111",2));
        assertEquals(-4041,MyInteger.parseInt("-7711",8));
        assertEquals(45,MyInteger.parseInt("231",4));
        assertEquals(487710,MyInteger.parseInt("7711E",16));
        assertEquals(487710,MyInteger.parseInt("7711e",16));
    }

}