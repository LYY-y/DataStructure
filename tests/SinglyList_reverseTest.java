import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyList_reverseTest {
    Integer[] integers={10,20,30,40,50};
    SinglyList singlyList1;
    SinglyList singlyList2=new SinglyList(integers);
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateReverse() {
        singlyList1=SinglyList_reverse.createReverse(integers);
        System.out.print("singlyList1:"+singlyList1.toString());
    }

    @Test
    public void testReverse(){
        SinglyList_reverse.reverse(singlyList2);
        System.out.print(singlyList2.toString());
    }
}