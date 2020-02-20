package Chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternMatchingTest {
    String taget;
    String pattern;

    @Before
    public void setUp() throws Exception {
        taget="abababcd";
        pattern="ab";
    }


    @Test
    public void testindexOf() {
        assertEquals(4,PatternMatching.indexOf(taget,pattern,3));
        assertEquals(0,PatternMatching.indexOf(taget,pattern));
    }

    @Test
    public void getNext() {
        pattern="abcabdabcabcaa";
        int[] next=PatternMatching.getNext(pattern);
        System.out.println("next数组为：");
        for (int i=0; i<next.length; i++){
            System.out.print("i="+i+", next[i]="+next[i]);
            System.out.println();
        }

    }
}