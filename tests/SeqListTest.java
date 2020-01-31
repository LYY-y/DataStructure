import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeqListTest {
    SeqList<Integer> seqList;
    @Before
    public void setUp() throws Exception {
        Integer[] integers={5,80,60,90,20};
        seqList=new SeqList<Integer>(integers);
    }



    @Test
    public void isEmpty() {
        assertFalse("该顺序表不是空的",seqList.isEmpty());
    }

    @Test
    public void size() {
        assertEquals("该顺序表的大小为：",5,seqList.size());
    }

    @Test
    public void get() {
        assertEquals("索引为2的值为：", 60, java.util.Optional.ofNullable(seqList.get(2)));
    }

    @Test
    public void set() {
    }

    @Test
    public void toString1() {
    }

    @Test
    public void toPreviousString() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insert1() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void search() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void insertDifferent() {
    }

    @Test
    public void remove1() {
    }

    @Test
    public void equals1() {
    }

    @Test
    public void addAll() {
    }
}