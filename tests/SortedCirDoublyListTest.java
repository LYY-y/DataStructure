import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedCirDoublyListTest {
    SortedCirDoublyList<Integer> sortedCirDoublyList;
    @Before
    public void setUp() throws Exception {
        sortedCirDoublyList=new SortedCirDoublyList<>();
    }

    @Test
    public void insert() {
        sortedCirDoublyList.insert(10);
        sortedCirDoublyList.insert(50);
        sortedCirDoublyList.insert(30);
        System.out.print(sortedCirDoublyList.toString());
    }
}