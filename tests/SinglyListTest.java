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
    public void testIsEmpty() {
        assertFalse("单链表不为空",singlyList.isEmpty());
    }

    @Test
    public void testGet() {
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

    @Test
    public void testInsert1(){
        singlyList.insert(5,60);
        assertEquals(60,(Object)singlyList.get(5));
    }

    @Test
    public void testInsert2(){
        singlyList.insert(60);
        assertEquals(60,(Object)singlyList.get(5));
    }

    @Test
    public void testRemove(){
        assertEquals(20,(Object)singlyList.remove(1));
        assertEquals(null,singlyList.remove(9));
        assertEquals(null,singlyList.remove(-5));
        System.out.print(singlyList.toString());
    }

    @Test
    public void testClear(){
        singlyList.clear();
        assertEquals(0,singlyList.size());
        System.out.print(singlyList.toString());
    }

    @Test
    public void testSearch(){
        assertEquals(50,(Object)singlyList.search(50).data);
    }

    @Test
    public void testContains(){
        assertTrue(singlyList.contains(50));
    }

    @Test
    public void testInsertDifferent(){
        assertEquals(60,(Object)singlyList.insertDifferent(60).data);
        assertEquals(null,singlyList.insertDifferent(40));
    }

    @Test
    public void testRemove2(){
        assertEquals(20,(Object)singlyList.remove((Integer) 20));
        System.out.print(singlyList.toString());
        assertEquals(null,singlyList.remove((Integer) 90));
        //assertEquals(null,singlyList.remove((Integer) 20));
        System.out.print(singlyList.toString());
    }
}