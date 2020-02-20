package Chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStringTest {
    MyString myString;

    @Before
    public void setUp() throws Exception {
        char[] values={'a','b','c','d','e'};
        myString=new MyString(values);
    }

    @Test
    public void testConstructor() {
        System.out.println(new MyString());
        System.out.println(new MyString("abcd"));
        char[] values={'a','b'};
        MyString myString=new MyString(values);
        System.out.println(myString);
        System.out.println(new MyString(myString));
    }

    @Test
    public void testCharAt(){
        assertEquals('c',myString.charAt(2));
    }

    @Test
    public void testSubString(){
        System.out.println("原字符串：["+myString+"]");
        System.out.println("截取第2-4位的字符串：["+myString.subString(2,4)+"]");
    }

    @Test
    public void testSubString2(){
        System.out.println("原字符串：["+myString+"]");
        System.out.println("截取第2位以后的字符串：["+myString.subString(2)+"]");
    }

    @Test
    public void testConcat(){
        MyString myString2=new MyString("fgh");
        System.out.println("原字符串：["+myString+"]");
        System.out.println("连接后字符串：["+myString.concat(myString2)+"]");
    }

    @Test
    public void testLength(){
        assertEquals(5,myString.length());
    }

    @Test
    public void testTrim(){
        myString=new MyString("abc  d ");
        System.out.println("原字符串：["+myString+"]");
        System.out.println("删除空白格后字符串：["+myString.trim()+"]");
    }

    @Test
    public void testEquals(){
        MyString myString1=new MyString("abcde");
        MyString myString2=new MyString("abcd");
        MyString myString3=new MyString("abcdgd");
        assertTrue(myString.equals(myString1));
        assertFalse(myString.equals(myString2));
        assertFalse(myString.equals(myString3));
    }

    @Test
    public void testCompareTo() {
        MyString myString2=new MyString("abcd");
        MyString myString3=new MyString("adcd");
        assertEquals(1,myString.compareTo(myString2));
        assertEquals(-2,myString.compareTo(myString3));
    }

    @Test
    public void testIndexOf(){
        MyString myString2=new MyString("abababcd");
        MyString pattern2=new MyString("abcd");
        MyString pattern3=new MyString("ab");
        assertEquals(4,myString2.indexOf(pattern2,1));
        assertEquals(0,myString2.indexOf(pattern3));
        assertEquals(4,myString2.indexOf(pattern3,3));
        assertEquals(-1,myString2.indexOf(pattern3,7));
    }

    @Test
    public void testReplaceAll(){
        MyString myString2=new MyString("abcdabdabcd");
        MyString pattern=new MyString("bcd");
        MyString replaceStr=new MyString("AAAA");
        MyString result=new MyString("aAAAAabdaAAAA");
        assertEquals(result,myString2.replaceAll(pattern,replaceStr));
    }

}