import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyListTest {
    SinglyList<Integer> singlyList;
    @Before
    public void setUp() throws Exception {
        Integer[] integers={50,10,40,20,30,40};
        singlyList=new SinglyList<Integer>(integers);
    }

    @Test
    public void testIsEmpty() {
        assertFalse("单链表不为空",singlyList.isEmpty());
    }

    @Test
    public void testGet() {
        assertEquals(20,(Object)singlyList.get(1));
        assertEquals(50,(Object)singlyList.get(4));
    }

    @Test
    public void testSet(){
        singlyList.set(0,50);
        assertEquals(50,(Object)singlyList.get(0));
    }

    @Test
    public void testSize(){
        assertEquals(5,singlyList.size());
    }

    @Test
    public void testToString(){
        System.out.print(singlyList.toString());
    }

    @Test
    public void testInsert1(){
        singlyList.insert(5,60);
        assertEquals(60,(Object)singlyList.get(5));
    }

    @Test
    public void testInsert2(){
        singlyList.insert(60);
        assertEquals(60,(Object)singlyList.get(5));
    }

    @Test
    public void testRemove(){
        assertEquals(20,(Object)singlyList.remove(1));
        assertEquals(null,singlyList.remove(9));
        assertEquals(null,singlyList.remove(-5));
    }

    @Test
    public void testClear(){
        singlyList.clear();
        assertEquals(0,singlyList.size());
    }

    @Test
    public void testSearch(){
        assertEquals(50,(Object)singlyList.search(50).data);
        assertEquals(10,(Object)singlyList.search(10).data);
    }

    @Test
    public void testContains(){
        assertTrue(singlyList.contains(50));
    }

    @Test
    public void testInsertDifferent(){
        assertEquals(60,(Object)singlyList.insertDifferent(60).data);
        assertEquals(40,(Object)singlyList.insertDifferent(40).data);
    }

    @Test
    public void testRemove2(){
        assertEquals(20,(Object)singlyList.remove((Integer) 20));
        assertEquals(50,(Object)singlyList.remove((Integer) 50));
        assertEquals(null,singlyList.remove((Integer) 90));
        assertEquals(null,singlyList.remove((Integer) 20));
    }

    @Test
    public void testSinglyList(){
        System.out.print((new SinglyList<Integer>(singlyList)).toString());
    }

    @Test
    public void testEquals(){
        Integer[] integers2={10,20,30,40,50,60};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        Integer[] integers3={10,20};
        SinglyList<Integer> singlyList3=new SinglyList<Integer>(integers3);
        Integer[] integers4={10,20,30,40,90};
        SinglyList<Integer> singlyList4=new SinglyList<Integer>(integers4);
        Integer[] integers5={10,20,30,40,50};
        SinglyList<Integer> singlyList5=new SinglyList<Integer>(integers5);
        assertFalse(singlyList.equals(singlyList2));
        assertFalse(singlyList.equals(singlyList3));
        assertFalse(singlyList.equals(singlyList4));
        assertTrue(singlyList.equals(singlyList5));
    }

    @Test
    public void testAddAll(){
        Integer[] integers2={10,20,30,40,50,60};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        singlyList.addAll(singlyList2);
        System.out.print(singlyList);
    }

    @Test
    public void testReplaceAll(){
        singlyList.replaceAll(50,0);
        System.out.println(singlyList.toString());
    }

    @Test
    public void testFirst(){
        assertEquals(50,(Object)singlyList.first().data);
    }

    @Test
    public void testNext(){
        assertEquals(10,(Object)singlyList.next(singlyList.first()).data);
    }

    @Test
    public void testPrevious(){
        assertEquals(null,singlyList.previous(singlyList.first()));
    }

    @Test
    public void testLast(){
        assertEquals(40,(Object)singlyList.last().data);
    }

    @Test
    public void testRemoveAll(){
        singlyList.removeAll(40);
        System.out.println(singlyList);
    }

    @Test
    public void testSubList(){
        System.out.println(singlyList.subList(3,5));
    }

    @Test
    public void testRemove3(){
        System.out.println("原表："+singlyList.toString());
        System.out.println("被删除元素："+singlyList.remove(1,3));
        System.out.println("删除后的表元素："+singlyList.toString());
    }

    @Test
    public void testContains2(){
        Integer[] integers2={10,10,40};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        assertFalse(singlyList.contains(singlyList2));

        Integer[] integers3={50,10,40,90};
        SinglyList<Integer> singlyList3=new SinglyList<Integer>(integers3);
        assertFalse(singlyList.contains(singlyList3));
    }

    @Test
    public void testAddAll2(){
        Integer[] integers2={100,200,300};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        singlyList.addAll(1,singlyList2);
        System.out.println(singlyList);
    }

    @Test
    public void testUnion(){
        Integer[] integers2={100,200,300};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        System.out.println(singlyList.union(singlyList2));
    }

    @Test
    public void testSubstract(){
        Integer[] integers2={10,40,30};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        System.out.println("原列表："+singlyList.toString());
        singlyList.substract(singlyList2);
        System.out.println("差集："+singlyList);
    }

    @Test
    public void testDifference(){
        Integer[] integers2={10,40,30};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        System.out.println("原列表："+singlyList.toString());
        System.out.println("返回的差集："+singlyList.difference(singlyList2));
    }

    @Test
    public void testRetainAll(){
        Integer[] integers2={10,40,30};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        System.out.println("原列表："+singlyList.toString());
        System.out.println("list表："+singlyList.toString());
        singlyList.retainAll(singlyList2);
        System.out.println("仅保留那些也包含在list中的元素："+singlyList);
    }

    @Test
    public void testIntersection(){
        Integer[] integers2={10,40,30};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        System.out.println("原列表："+singlyList.toString());
        System.out.println("list表："+singlyList.toString());
        System.out.println("交集："+singlyList.intersection(singlyList2));
    }

    @Test
    public void testSearch2(){
        Integer[] integers2={20,30};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        assertEquals(20,(Object)singlyList.search(singlyList2).data);
    }

    @Test
    public void testAverage(){
        Integer[] integers2={11,5,5};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        assertEquals( 7,new SinglyList<>().average(singlyList2),0.01);
    }

    @Test
    public void testAverageExceptMaxMin(){
        Integer[] integers2={1,5,5,5,5,9};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        assertEquals( 5,new SinglyList<>().averageExceptMaxMin(singlyList2),0.01);
    }

    @Test
    public void testMax(){
        Integer[] integers2={11,5,5,9};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        assertEquals( 11,(Object)new SinglyList<>().max(singlyList2));
    }

    @Test
    public void testIsSorted(){
        Integer[] integers2={1,2,5};
        SinglyList<Integer> singlyList2=new SinglyList<Integer>(integers2);
        assertTrue(new SinglyList<>().isSorted(singlyList2,true));
        Integer[] integers3={3,2,5};
        SinglyList<Integer> singlyList3=new SinglyList<Integer>(integers3);
        assertFalse(new SinglyList<>().isSorted(singlyList3,true));
        Integer[] integers4={100,20,5};
        SinglyList<Integer> singlyList4=new SinglyList<Integer>(integers4);
        assertTrue(new SinglyList<>().isSorted(singlyList4,false));
    }

    @Test
    public void testGradeCount(){
        SinglyList<Student> list;
        int[] grade;
        SinglyList result;

        Student[] students={new Student("王红",85),new Student("张明",75),
                new Student("李强",90), new Student("崔小兵",80),
                new Student("陈新诺",60),new Student("林二",55),
                new Student("刘毅",100)};

        list=new SinglyList<Student>(students);
        list.insert(new Student("刘二",88));
        grade=new int[]{0,60,70,80,90,100};

        result=new SinglyList<Student>().gradeCount(list,grade);
        int[] excepts={1,1,1,3,1,1};


    }
}