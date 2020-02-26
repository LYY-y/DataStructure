import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomVideoTest {
    RandomVideo randomVideo;
    @Before
    public void setUp() throws Exception {
        randomVideo=new RandomVideo(5,);
    }

    @Test
    public void craetRandom() {
        System.out.print(randomVideo.craetRandom(0,100,5)+", ");
    }
}