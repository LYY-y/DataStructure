import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSeqListTest {
    SortedSeqList<Integer> seqList;
    @Before
    public void setUp() throws Exception {
        Integer[] values={10,50,30};
        seqList=new SortedSeqList<Integer>(values);
    }

    @Test
    public void insert() {
        System.out.print(seqList.insert(20));
    }

    @Test
    public void insertDifferent() {
        System.out.print("this is insertDifferent");
    }

    @Test
    public void set() {
        System.out.print("this is set");

    }
    @Ignore
    @Test
    public void insert1() {
        seqList.insert(10,5);

    }
}