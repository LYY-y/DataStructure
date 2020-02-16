import Chapter2.SortedSeqList;
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
    public void testInsert() {
        assertEquals(3,sortedSeqList.insert(70));
    }

    @Test
    public void testInsertDifferent() {
        assertEquals(-1,sortedSeqList.insertDifferent(60));
    }

    @Test(expected=java.lang.UnsupportedOperationException.class)
    public void testSet() {
        sortedSeqList.set(0,50);
    }

    @Test(expected=java.lang.UnsupportedOperationException.class)
    public void testInsert1() {
        sortedSeqList.insert(0,80);
    }

    @Test
    public void testSearch(){
        assertEquals(1,sortedSeqList.search(20));
    }

    @Test
    public void testRemove(){
        Integer[] excepts={5,60,80,90};
        assertEquals(20,(Object)sortedSeqList.remove((Integer) 20));
        for (int i=0; i<excepts.length; i++){
            assertEquals(excepts[i],sortedSeqList.element[i]);
        }
    }

    @Test
    public void testAddAll(){
        Integer[] integersAdd={1,2,99};
        SortedSeqList<Integer> sortedSeqListAdd=new SortedSeqList<Integer>(integersAdd);
        sortedSeqList.addAll(sortedSeqListAdd);
        System.out.print(sortedSeqList.toString());
    }

    @Test
    public void testCreatePrime(){
        System.out.println("100以内的素数："+sortedSeqList.createPrime(100).toString());
    }
}