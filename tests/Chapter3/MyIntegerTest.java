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

    @Test
    public void testToHexString(){
        assertEquals("0x000003e8",MyInteger.toHexString(1000));
        assertEquals("0xffffff80",MyInteger.toHexString(-128));
        assertEquals("0xffffffff",MyInteger.toHexString(-1));
        assertEquals("0x0000007f",MyInteger.toHexString(127));

    }

    @Test
    public void testToBinaryString(){
        assertEquals("10000000000000000000000000000000",MyInteger.toBinaryString(Integer.MIN_VALUE));
        assertEquals("00000000000000000000000001111111",MyInteger.toBinaryString(127));
        assertEquals("11111111111111111111111111111011",MyInteger.toBinaryString(-5));
    }

    @Test
    public void testToOctalString(){
        assertEquals("00000000177",MyInteger.toOctalString(127));
        assertEquals(Integer.toOctalString(-127),MyInteger.toOctalString(-127));
    }

    @Test
    public void testToString2(){
        assertEquals(Integer.toString(50,2),MyInteger.toString(50,2));
        assertEquals(Integer.toString(-50,16),MyInteger.toString( -50,16));
        assertEquals(Integer.toString(-188,7),MyInteger.toString(-188,7));
    }


}