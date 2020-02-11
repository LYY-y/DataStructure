import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolySinglyListTest {
    PolySinglyList polySinglyList;

    @Before
    public void setUp() throws Exception {
        TermX[] terms={new TermX(2,0),new TermX(-1,1),new TermX(1,2),
                new TermX(-9,4),new TermX(2,7),new TermX(-7,9)};
        polySinglyList=new PolySinglyList(terms);
    }

    @Test
    public void addAll() {
        TermX[] terms1={new TermX(-1,0),new TermX(1,1),new TermX(-1,2),
                new TermX(10,4),new TermX(-3,8),new TermX(5,10),new TermX(9,11)};
        PolySinglyList polySinglyList1=new PolySinglyList(terms1);
        polySinglyList.addAll(polySinglyList1);
        System.out.print(polySinglyList.toString());
    }
}