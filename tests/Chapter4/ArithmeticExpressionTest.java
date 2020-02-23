package Chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticExpressionTest {

    @Test
    public void testIntValue() {
        String infix="+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)+0";
        System.out.println(infix+"="+new ArithmeticExpression(infix).intValue());
    }
}