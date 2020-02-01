import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSeqListTest {
    SortedSeqList<Integer> sortedSeqList;
    @Before
    public void setUp() throws Exception {
        Integer[] integers={5,80,60,90,20};
        sortedSeqList=new SortedSeqList<Integer>(integers);
    }

    @Test
    public void insert() {
        assertEquals(3,sortedSeqList.insert(70));
    }

    @Test
    public void insertDifferent() {
        assertEquals(-1,sortedSeqList.insertDifferent(60));
    }

    @Test(expected=java.lang.UnsupportedOperationException.class)
    public void set() {
        sortedSeqList.set(0,50);
    }

    @Test(expected=java.lang.UnsupportedOperationException.class)
    public void insert1() {
        sortedSeqList.insert(0,80);
    }
}