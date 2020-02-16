import Chapter2.CirDoublyList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirDoublyListTest {
    CirDoublyList<Integer> cirDoublyList;
    Integer[] integers={10,20,30};

    @Before
    public void setUp() throws Exception {
        cirDoublyList=new CirDoublyList(integers);
    }

    @Test
    public void testCirDoublyList(){
        Integer[] integers2={40,50,60};
        CirDoublyList<Integer> cirDoublyList2=new CirDoublyList<Integer>(integers2);
        cirDoublyList=new CirDoublyList<>(cirDoublyList2);
        System.out.print(cirDoublyList.toString());
    }

    @Test
    public void isEmpty() {
        assertFalse(cirDoublyList.isEmpty());
    }

    @Test
    public void testInsert() {
        cirDoublyList.insert(0,10);
        System.out.print(cirDoublyList.toString());
    }

    @Test
    public void testInsert1() {
        cirDoublyList.insert(10);
        cirDoublyList.insert(20);
        System.out.print(cirDoublyList.toString());
    }

    @Ignore
    @Test
    public void testToPreviousString() {
        cirDoublyList.insert(10);
        cirDoublyList.insert(20);
        System.out.print(cirDoublyList.toPreviousString());
    }

    @Test
    public void testRemoveLast() {
        cirDoublyList.insert(10);
        cirDoublyList.insert(20);
        cirDoublyList.insert(1,50);
        System.out.println("删除前："+cirDoublyList.toString());
        assertEquals(20,(Object)cirDoublyList.removeLast());
        System.out.println("删除后："+cirDoublyList.toString());
    }

    @Test
    public void testSize(){
        assertEquals(3,cirDoublyList.size());
    }

    @Test
    public void teatGet(){
        assertEquals(20,(Object)cirDoublyList.get(1));
    }

    @Test
    public void testSet(){
        cirDoublyList.set(0,11);
        assertEquals(11,(Object)cirDoublyList.get(0));
    }

    @Test
    public void testRemove(){
        assertEquals(10,(Object)cirDoublyList.remove(0));
        assertEquals(30,(Object)cirDoublyList.remove(1));
        System.out.print(cirDoublyList.toString());
    }

    @Test
    public void testClear(){
        cirDoublyList.clear();
        assertEquals(0,cirDoublyList.size());
    }

    @Test
    public void testSearch(){
        assertEquals(10,(Object)cirDoublyList.search(10).data);
        assertEquals(30,(Object)cirDoublyList.search(30).data);
        assertEquals(null,cirDoublyList.search(90));
    }

    @Test
    public void testInsertDifferent(){
        assertEquals(40,(Object)cirDoublyList.insertDifferent(40).data);
        assertEquals(null,cirDoublyList.insertDifferent(10));
        System.out.print(cirDoublyList.toString());
    }

    @Test
    public void testRemove2(){
        assertEquals(10,(Object)cirDoublyList.remove((Integer) 10));
        assertEquals(30,(Object)cirDoublyList.remove((Integer) 30));
        assertEquals(null,cirDoublyList.remove((Integer) 90));
        System.out.print(cirDoublyList.toString());
    }

    @Test
    public  void testEquals(){
        Integer[] integers2={40,50,60};
        Integer[] integers3={10,20,30};
        CirDoublyList <Integer> cirDoublyList2=new CirDoublyList<Integer>(integers2);
        CirDoublyList <Integer> cirDoublyList3=new CirDoublyList<Integer>(integers3);
        assertTrue(cirDoublyList.equals(cirDoublyList3));
        assertFalse(cirDoublyList.equals(cirDoublyList2));
    }

    @Test
    public void testAddAll(){
        Integer[] integers2={40,50,60};
        CirDoublyList<Integer> cirDoublyList2=new CirDoublyList<Integer>(integers2);
        cirDoublyList.addAll(cirDoublyList2);
        System.out.print(cirDoublyList);
    }
}