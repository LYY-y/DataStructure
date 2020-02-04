import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyList_reverseTest {
    Integer[] integers={10,20,30,40,50};
    SinglyList_reverse singlyList_reverse=new SinglyList_reverse();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateReverse() {
        singlyList_reverse.createReverse(integers);
    }
}