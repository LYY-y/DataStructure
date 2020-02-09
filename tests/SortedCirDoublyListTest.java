import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedCirDoublyListTest {
    Integer[] integers={10,20,30};
    SortedCirDoublyList<Integer> sortedCirDoublyList;

    @Before
    public void setUp() throws Exception {
        sortedCirDoublyList=new SortedCirDoublyList<>(integers);
    }

    @Test
    public void testCirDoublyListStructure1(){
        Integer[] integers2={80,60,50,70};
        CirDoublyList<Integer> cirDoublyList=new CirDoublyList<Integer>(integers2);
        sortedCirDoublyList=new SortedCirDoublyList<Integer>(cirDoublyList);
        System.out.print(sortedCirDoublyList.toString());
    }

    @Test
    public void testCirDoublyListStructure2(){
        Integer[] integers2={80,60,50,70};
        SortedCirDoublyList<Integer> sortedCirDoublyList2=new SortedCirDoublyList<Integer>(integers2);
        sortedCirDoublyList=new SortedCirDoublyList<Integer>(sortedCirDoublyList2);
        System.out.print(sortedCirDoublyList.toString());
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testSet() {
        sortedCirDoublyList.set(1,50);
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testInsert1() {
        sortedCirDoublyList.insert(2,50);
    }

    @Test
    public void testInsert2() {
        sortedCirDoublyList.insert(10);
        sortedCirDoublyList.insert(50);
        sortedCirDoublyList.insert(30);
        System.out.print(sortedCirDoublyList.toString());
    }

    @Test
    public void testSearch() {
        assertEquals(10,(Object)sortedCirDoublyList.search(10).data);
        assertEquals(30,(Object)sortedCirDoublyList.search(30).data);
    }

    @Test
    public void testInsertDifferent() {
        assertEquals(15,(Object)sortedCirDoublyList.insertDifferent(15).data);
        assertEquals(null,sortedCirDoublyList.insertDifferent(10));
    }

    @Test
    public void testAddAll() {
        Integer[] integers2={80,60,10,70};
        CirDoublyList<Integer> cirDoublyList2=new CirDoublyList<Integer>(integers2);
        sortedCirDoublyList.addAll(cirDoublyList2);
        System.out.print(sortedCirDoublyList.toString());
    }
}