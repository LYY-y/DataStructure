import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

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
        assertEquals(50,(Object)singlyList.get(4));
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
    }

    @Test
    public void testClear(){
        singlyList.clear();
        assertEquals(0,singlyList.size());
    }

    @Test
    public void testSearch(){
        assertEquals(50,(Object)singlyList.search(50).data);
        assertEquals(10,(Object)singlyList.search(10).data);
    }

    @Test
    public void testContains(){
        assertTrue(singlyList.contains(50));
    }

    @Test
    public void testInsertDifferent(){
        assertEquals(60,(Object)singlyList.insertDifferent(60).data);
        assertEquals(40,(Object)singlyList.insertDifferent(40).data);
    }

    @Test
    public void testRemove2(){
        assertEquals(20,(Object)singlyList.remove((Integer) 20));
        assertEquals(50,(Object)singlyList.remove((Integer) 50));
        assertEquals(null,singlyList.remove((Integer) 90));
        assertEquals(null,singlyList.remove((Integer) 20));
    }

    @Test
    public void testSinglyList(){
        System.out.print((new SinglyList<Integer>(singlyList)).toString());
    }

    @Test
    public void testEquals(){
        Integer[] integers2={10,20,30,40,50,60};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        Integer[] integers3={10,20};
        SinglyList<Integer> singlyList3=new SinglyList<Integer>(integers3);
        Integer[] integers4={10,20,30,40,90};
        SinglyList<Integer> singlyList4=new SinglyList<Integer>(integers4);
        Integer[] integers5={10,20,30,40,50};
        SinglyList<Integer> singlyList5=new SinglyList<Integer>(integers5);
        assertFalse(singlyList.equals(singlyList2));
        assertFalse(singlyList.equals(singlyList3));
        assertFalse(singlyList.equals(singlyList4));
        assertTrue(singlyList.equals(singlyList5));
    }

    @Test
    public void testAddAll(){
        Integer[] integers2={10,20,30,40,50,60};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        singlyList.addAll(singlyList2);
        System.out.print(singlyList);
    }
}