import Chapter2.SortedSinglyList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSinglyListTest {
    Integer[] integers={5,80,60,90,20};
    SortedSinglyList sortedSinglyList;

    @Before
    public void setUp() throws Exception {
        sortedSinglyList=new SortedSinglyList(integers);
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testSet() {
        sortedSinglyList.set(0,5);
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testInsert() {
        sortedSinglyList.insert(0,5);
    }

    @Test
    public void testInsert1() {
        assertEquals(10,sortedSinglyList.insert((Integer)10).data);
        assertEquals(50,sortedSinglyList.insert((Integer)50).data);
        assertEquals(30,sortedSinglyList.insert((Integer)30).data);
        assertEquals(30,sortedSinglyList.insert((Integer)30).data);
        System.out.print(sortedSinglyList.toString());
    }

    @Test
    public void testSearch() {
        assertEquals(null,sortedSinglyList.search(70));
        assertEquals(90,sortedSinglyList.search(90).data);
    }

    @Test
    public void insertDifferent() {
        assertEquals(10,sortedSinglyList.insertDifferent((Integer)10).data);
        assertEquals(50,sortedSinglyList.insertDifferent((Integer)50).data);
        assertEquals(30,sortedSinglyList.insertDifferent((Integer)30).data);
        assertEquals(null,sortedSinglyList.insertDifferent((Integer)30));
        System.out.print(sortedSinglyList.toString());
    }

    @Test
    public void testRemove() {
        assertEquals(90,sortedSinglyList.remove((Integer)90));
        assertEquals(5,sortedSinglyList.remove((Integer)5));
        assertEquals(null,sortedSinglyList.remove((Integer)25));
        System.out.print(sortedSinglyList.toString());
    }

    @Test
    public void testAddAll() {
        Integer[] integers2={100,1};
        SortedSinglyList sortedSinglyList2=new SortedSinglyList(integers2);
        sortedSinglyList.addAll(sortedSinglyList2);
        System.out.print(sortedSinglyList.toString());
    }
}