import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

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
        assertEquals("索引为2的值为：", 60, (Object)seqList.get(2));
    }

    @Test
    public void set() {
        seqList.set(0,70);
        System.out.print(seqList.toString());
    }
@Ignore
    @Test
    public void toString1() {

    }
@Ignore
    @Test
    public void toPreviousString() {
    }

    @Test
    public void insert() {
        seqList.insert(2,99);
        Integer[] expects={5,80,99,60,90,20};
        assertArrayEquals(expects,seqList.element);
    }

    @Test
    public void insert1() {
        seqList.insert(99);
        Integer[] expects={5,80,60,90,20,99};
        assertArrayEquals(expects,seqList.element);
    }

    @Test
    public void remove() {
        assertEquals(80,(Object)seqList.remove(1));
    }

    @Test
    public void clear() {
        seqList.clear();
        Integer[] expects={};
        assertArrayEquals(expects,seqList.element);
    }

    @Test
    public void search() {
        assertEquals(2,seqList.search(60));
    }

    @Test
    public void contains() {
        assertTrue("顺序表中存在60",seqList.contains(60));
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