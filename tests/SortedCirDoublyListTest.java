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

    }
}