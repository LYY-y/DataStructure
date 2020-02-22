package Chapter4;

public class Expression {
    /**返回将infix中缀表达式转换成的后缀表达式*/
    public static StringBuilder toPostfix(String infix){
        Stack<String> stack = new SeqStack<String>(infix.length());
        StringBuilder postfix = new StringBuilder(infix.length()*2);
        int i=0;
        while (i<infix.length()){
            char ch=infix.charAt(i);
            if (ch>='0' && ch<='9'){
                postfix.append(ch+"");
            }else {
                postfix.append(" ");
                if (ch == '(' || ch == '（'){
                    stack.push(ch+"");
                }else if (ch == '*' || ch == '/'){
                    while ("*".equals(stack.peek()) || "/".equals(stack.peek())){
                        postfix.append(stack.pop());
                    }
                    stack.push(ch+"");
                }else if (ch == '+' || ch == '-'){
                    while ("*".equals(stack.peek()) || "/".equals(stack.peek()) || ("+").equals(stack.peek()) || ("-").equals(stack.peek())){
                        postfix.append(stack.pop());
                    }
                    stack.push(ch+"");
                }else if (ch == ')' || ch == '）'){
                    while ( !("(".equals(stack.peek())) && !("（".equals(stack.peek()))){
                        postfix.append(stack.pop());
                    }
                    stack.pop();
                }
            }
            i++;
        }
        while (!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix;
    }

    /**计算后缀表达式的值*/
    public static int toValue(StringBuilder postfix){
        Stack<Integer> stack=new SeqStack<Integer>(postfix.length());
        int value=0;
        int i=0;
        StringBuilder intStr=new StringBuilder();
        while (i<postfix.length()){
            char ch=postfix.charAt(i);
            if (ch < '0'|| ch>'9'){
                if (intStr.length()!=0){
                    value = Integer.parseInt(intStr.toString());
                    stack.push(value);
                    intStr.setLength(0);
                }
                if (ch==' '){
                    i++;
                    continue;
                }

            }
            if (ch >= '0' && ch <= '9'){
                if (intStr.length()==0){
                    intStr=new StringBuilder();
                }
                intStr.append(ch);
            }else {
                int value1=stack.pop();
                int value2=stack.pop();
                if (ch=='+'){
                    value=value1+value2;
                }else if (ch=='-'){
                    value=value2-value1;
                }else if (ch=='*'){
                    value=value1*value2;
                }else if (ch=='/'){
                    value=value2/value1;
                }
                stack.push(value);
            }
            i++;
        }
        return stack.peek();
    }
}
