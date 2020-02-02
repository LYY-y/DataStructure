import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeqList_StudentTest {
    SeqList<Student> list;
    SeqList<Student> slist;
    int[] grade;
    int[] result;
    @Before
    public void setUp() throws Exception {
        Student[] students={new Student("王红",85),new Student("张明",75),
                new Student("李强",90), new Student("崔小兵",80),
                new Student("陈新诺",60),new Student("林二",55),
                new Student("刘毅",100)};

        list=new SeqList<Student>(students);
        slist=new SortedSeqList<Student>(students);
        list.insert(new Student("刘二",88));
        grade=new int[]{0,60,70,80,90,100};

    }

    @Test
    public void testGradeCount() {
        result= SeqList_Student.gradeCount(list,grade);
        int[] excepts={1,1,1,3,1,1};
        assertArrayEquals(excepts,result);
    }

    @Test
    public void testPrintCount() {
        result= SeqList_Student.gradeCount(list,grade);
        SeqList_Student.printCount(list,grade,result);
        SeqList_Student.printCount(slist,grade,result);
    }

    @Test
    public void testSearchByName(){
        SeqList_Student.searchByName(list,new Student("林二",0));
    }

    @Test
    public void testSearchByScore(){
        SeqList_Student.searchByScore(slist,new Student("",75));
    }
}