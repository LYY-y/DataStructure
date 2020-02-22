package Chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void testToPostfix() {
        String infix="1+2*(3-4)+5";
        System.out.println("1+2*(3-4)+5的后缀表达式："+Expression.toPostfix(infix));
        String infix2="123+10*(45-50+20)/((35-25)*2+10)-11";
        System.out.println("123+10*(45-50+20)/((35-25)*2+10)-11的后缀表达式："+Expression.toPostfix(infix2));
    }

    @Test
    public void testToValue() {
        StringBuilder postfix=new StringBuilder("1 2 3 4 - *+5+");
        System.out.println("1+2*(3-4)+5的结果为："+Expression.toValue(postfix));
        StringBuilder postfix2=new StringBuilder("123 10  45 50 -20 + *  35 25 - 2 *10 + /+11-");
        System.out.println("123+10*(45-50+20)/((35-25)*2+10)-11的结果为："+Expression.toValue(postfix2));
    }
}