package Chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStringBufferTest {
    MyStringBuffer myStringBuffer;

    @Before
    public void setUp() throws Exception {
        myStringBuffer=new MyStringBuffer("hello");
    }

    @Test
    public void length() {
        assertEquals(5,myStringBuffer.length());
    }

    @Test
    public void capacity() {
        assertEquals(21,myStringBuffer.capacity());
    }

    @Test
    public void toString1() {
        System.out.println(myStringBuffer.toString());
    }

    @Test
    public void charAt() {
        assertEquals('e',myStringBuffer.charAt(1));
    }

    @Test
    public void setCharAt() {
        myStringBuffer.setCharAt(4,'e');
        assertEquals("helle",myStringBuffer.toString());
    }

    @Test
    public void setInsert() {
        myStringBuffer.insert(0,"999");
        myStringBuffer.insert(7,(String) null);
        myStringBuffer.insert(5,"2222222222");
        assertEquals("999he2222222222llnullo",myStringBuffer.toString());
    }

    @Test
    public void setInsert2() {
        MyStringBuffer myStringBuffer2=new MyStringBuffer("999");
        myStringBuffer.insert(0,myStringBuffer2);
        assertEquals("999hello",myStringBuffer.toString());
    }

    @Test
    public void setInsert3() {
        myStringBuffer.insert(0,true);
        assertEquals("truehello",myStringBuffer.toString());
    }

    @Test
    public void setAppend() {
        myStringBuffer.append("abc");
        assertEquals("helloabc",myStringBuffer.toString());
    }

    @Test
    public void testDelete(){
        assertEquals("he",myStringBuffer.delete(2,10).toString());
    }

    @Test
    public void testReplace(){
        assertEquals("heabco",myStringBuffer.replace(2,4,"abc").toString());
        myStringBuffer=new MyStringBuffer("hello");
        assertEquals("hebo",myStringBuffer.replace(2,4,"b").toString());
        myStringBuffer=new MyStringBuffer("hello");
        assertEquals("heb",myStringBuffer.replace(2,10,"b").toString());
    }
}