import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

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
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }
    }

    @Test
    public void insert1() {
        seqList.insert(99);
        Integer[] expects={5,80,60,90,20,99};
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }
    }

    @Test
    public void remove() {
        assertEquals(80,(Object)seqList.remove(1));
    }

    @Test
    public void clear() {
        seqList.clear();
        Integer[] expects={};
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }    }

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
        assertEquals(-1,seqList.insertDifferent(80));
    }

    @Test
    public void remove1() {
        assertEquals(80,(Object)seqList.remove(1));
    }

    @Test
    public void equals1() {
        Integer[] integersTest={1,2,3,4};
        assertFalse(seqList.equals(integersTest));
    }

    @Test
    public void addAll() {
        Integer[] addArr={10,50};
        SeqList<Integer> seqListAdd=new SeqList<Integer>(addArr);
        Integer[] expects={5,80,60,90,20,10,50};
        seqList.addAll(seqListAdd);
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }

    }
}