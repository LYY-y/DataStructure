import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyListTest {
    SinglyList<Integer> singlyList;
    @Before
    public void setUp() throws Exception {
        Integer[] integers={10,20,30,40,50};
        singlyList=new SinglyList<Integer>(integers);

    }

    @Test
    public void isEmpty() {
        assertFalse("单链表不为空",singlyList.isEmpty());
    }

    @Test
    public void get() {
        assertEquals(20,(Object)singlyList.get(1));
    }

    @Test
    public void testSet(){
        singlyList.set(0,50);
        assertEquals(50,(Object)singlyList.get(0));
    }

    @Test
    public void testSize(){
        assertEquals(5,singlyList.size());
    }

    @Test
    public void testToString(){
        System.out.print(singlyList.toString());
    }
}