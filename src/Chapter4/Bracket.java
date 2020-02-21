package Chapter4;

public class Bracket {
    /**检查infix表达式中的圆括号是否匹配。若匹配，返回空串；否则返回错误信息*/
    public static String isMatched(String infix){
        Stack<String> stack=new SeqStack<String>();
        int i=0;
        char ch;
        while (i<infix.length()){
            ch = infix.charAt(i);
            if (ch == '('||ch == '（'){
                stack.push(ch+"");
            }else if (ch == ')' || ch == '）'){
                if ("(".equals(stack.peek()) || "（".equals(stack.peek())){
                    stack.pop();
                }else {
                    return "圆括号不匹配！";
                }
            }
            i++;
        }
        if (!stack.isEmpty()){
            return "圆括号不匹配！";
        }
        return "";
    }
}
