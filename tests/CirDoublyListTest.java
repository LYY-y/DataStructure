import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirDoublyListTest {
    CirDoublyList<Integer> cirDoublyList;
    CirDoublyList<Integer> cirDoublyList2;
    Integer[] integers={10,20,30};
    Integer[] integers2={40,50,60};

    @Before
    public void setUp() throws Exception {
        cirDoublyList=new CirDoublyList();
    }

    @Test
    public void testCirDoublyList(){
        cirDoublyList2=new CirDoublyList<Integer>(integers2);
        cirDoublyList=new CirDoublyList<>(cirDoublyList2);
        System.out.print(cirDoublyList.toPreviousString());
    }

    @Test
    public void isEmpty() {
        assertTrue(cirDoublyList.isEmpty());
    }

    @Test
    public void insert() {
        cirDoublyList.insert(0,10);
        System.out.print(cirDoublyList.toPreviousString());
    }

    @Test
    public void insert1() {
        cirDoublyList.insert(10);
        cirDoublyList.insert(20);
        System.out.print(cirDoublyList.toPreviousString());
    }

    @Ignore
    @Test
    public void toPreviousString() {
        cirDoublyList.insert(10);
        cirDoublyList.insert(20);
        System.out.print(cirDoublyList.toPreviousString());
    }

    @Test
    public void removeLast() {
        cirDoublyList.insert(10);
        cirDoublyList.insert(20);
        cirDoublyList.insert(1,50);
        System.out.println("删除前："+cirDoublyList.toPreviousString());
        assertEquals(20,(Object)cirDoublyList.removeLast());
        System.out.println("删除后："+cirDoublyList.toPreviousString());
    }
}