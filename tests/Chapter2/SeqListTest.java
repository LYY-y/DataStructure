package Chapter2;

import Chapter2.SeqList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

public class SeqListTest {
    SeqList<Integer> seqList;
    @Before
    public void setUp() throws Exception {
        Integer[] integers={20,5,80,20,60,80,20,20};
        seqList=new SeqList<Integer>(integers);
    }

    @Test
    public void testIsEmpty() {
        assertFalse("该顺序表不是空的",seqList.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals("该顺序表的大小为：",5,seqList.size());
    }

    @Test
    public void testGet() {
        assertEquals("索引为2的值为：", 60, (Object)seqList.get(2));
    }

    @Test
    public void testSet() {
        seqList.set(0,70);
        System.out.print(seqList.toString());
    }
@Ignore
    @Test
    public void testToString1() {

    }
@Ignore
    @Test
    public void testToPreviousString() {
    }

    @Test
    public void testInsert() {
        seqList.insert(2,99);
        Integer[] expects={5,80,99,60,90,20};
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }
    }

    @Test
    public void testInsert1() {
        seqList.insert(99);
        Integer[] expects={5,80,60,90,20,99};
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }
    }

    @Test
    public void testRemove() {
        assertEquals(80,(Object)seqList.remove(1));
    }

    @Test
    public void testClear() {
        seqList.clear();
        Integer[] expects={};
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }    }

    @Test
    public void testSearch() {
        assertEquals(2,seqList.search(60));
    }

    @Test
    public void testContains() {
        assertTrue("顺序表中存在60",seqList.contains(60));
    }

    @Test
    public void testInsertDifferent() {
        assertEquals(-1,seqList.insertDifferent(80));
    }

    @Test
    public void testRemove1() {
        assertEquals(80,(Object)seqList.remove(1));
    }

    @Test
    public void testEquals1() {
        Integer[] integersTest={1,2,3,4};
        assertFalse(seqList.equals(integersTest));
    }

    @Test
    public void testAddAll() {
        Integer[] addArr={10,50};
        SeqList<Integer> seqListAdd=new SeqList<Integer>(addArr);
        Integer[] expects={5,80,60,90,20,10,50};
        seqList.addAll(seqListAdd);
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],seqList.element[i]);
        }

    }

    @Test
    public void testUnion(){
        Integer[] unionArr={10,50};
        SeqList<Integer> seqListAdd=new SeqList<Integer>(unionArr);
        Integer[] expects={5,80,60,90,20,10,50};
        SeqList<Integer> result=seqList.union(seqListAdd);
        for (int i=0; i<expects.length; i++){
            assertEquals(expects[i],result.element[i]);
        }
    }

    @Test
    public void testRemoveAll(){
        seqList.removeAll(20);
        System.out.println(seqList.toString());

        Integer[] integers2={20,20,20,20,20};
        SeqList seqList2=new SeqList<Integer>(integers2);
        seqList2.removeAll(20);
        System.out.println(seqList2.toString());
    }

    @Test
    public void testReplaceFirst(){
        seqList.replaceFirst(20,10);
        System.out.println(seqList.toString());
    }

    @Test
    public void testReplaceAll(){
        seqList.replaceAll(20,2);
        System.out.println(seqList.toString());
    }

    @Test
    public void testSearchLast(){
        assertEquals(5,seqList.searchLast(80));
    }

    @Test
    public void testRemoveLast(){
        seqList.removeLast(80);
        System.out.println(seqList.toString());
    }

    @Test
    public void testReplaceLast(){
        seqList.replaceLast(80,88);
        System.out.println(seqList.toString());
    }
}