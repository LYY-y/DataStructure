package Chapter2;

import Chapter2.PolySinglyList;
import Chapter2.TermX;
import org.junit.Before;
import org.junit.Test;

public class PolySinglyListTest {
    PolySinglyList polySinglyList;

    @Before
    public void setUp() throws Exception {
        TermX[] terms={new TermX(2,0),new TermX(-1,1),new TermX(1,2),
                new TermX(-9,4),new TermX(2,7),new TermX(-7,9)};
        polySinglyList=new PolySinglyList(terms);
    }

    @Test
    public void testAddAll() {
        TermX[] terms1={new TermX(-1,0),new TermX(1,1),new TermX(-1,2),
                new TermX(10,4),new TermX(-3,8),new TermX(5,10),new TermX(9,11)};
        PolySinglyList polySinglyList1=new PolySinglyList(terms1);
        System.out.println(polySinglyList.toString() + polySinglyList1.toString());
        polySinglyList.addAll(polySinglyList1);
        System.out.print("相加后：" + polySinglyList.toString());
    }

    @Test
    public void testUnion() {
        TermX[] terms1={new TermX(-1,0),new TermX(1,1),new TermX(-1,2),
                new TermX(10,4),new TermX(-3,8),new TermX(5,10),new TermX(9,11)};
        PolySinglyList polySinglyList1=new PolySinglyList(terms1);
        System.out.print(polySinglyList.union(polySinglyList1));
    }

    @Test
    public void testMulAll(){
        TermX[] terms1={new TermX(1,0),new TermX(3,1)};
        PolySinglyList polySinglyList1=new PolySinglyList(terms1);
        TermX[] terms2={new TermX(2,1),new TermX(3,2),new TermX(2,3)};
        PolySinglyList polySinglyList2=new PolySinglyList(terms2);
        System.out.print(polySinglyList1.mulAll(polySinglyList2));
    }
}