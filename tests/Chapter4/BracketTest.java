package Chapter4;

import org.junit.Before;
import org.junit.Test;

import static Chapter4.Bracket.isMatched;
import static org.junit.Assert.*;

public class BracketTest {

    @Test
    public void testIsMatched() {
        System.out.println("测试1：((1+2)*3+4)("+isMatched("((1+2)*3+4)("));
        System.out.println("测试2：((1+2)*3+4)"+isMatched("((1+2)*3+4)"));
    }
}