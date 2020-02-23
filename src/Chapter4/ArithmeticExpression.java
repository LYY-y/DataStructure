package Chapter4;
/**算术表达式*/
public class ArithmeticExpression {
    /**中缀算术表达式字符串*/
    private String infix;
    /**当前字符序号*/
    private int index;

    public ArithmeticExpression(String infix){
        this.infix=infix;
        this.index=0;
    }

    /**计算从index开始的一个（子）算术表达式，返回整数值，其中进行多（项）加减运算*/
    public int intValue(){
        int value=this.term();
        while (this.index<this.infix.length()){
            char ch=this.infix.charAt(this.index);
            if (ch == '+' || ch == '-') {
                this.index++;
                int value2 = this.term();
                if (ch == '+') {
                    value = value + value2;
                } else if (ch == '-') {
                    value = value - value2;
                }
            }else {
                break;
            }
        }
        return value;
    }

    /**计算从index开始的一<项>，其中进行多<因子>的乘除运算*/
    private int term(){
        int value=this.factor();
        while (this.index<this.infix.length()) {
            char ch = this.infix.charAt(this.index);
            if (ch == '*' || ch == '/' || ch == '%') {
                this.index++;
                int value2 = this.factor();
                if (ch == '*') {
                    value = value * value2;
                } else if (ch == '/') {
                    value = value / value2;
                } else if (ch == '%') {
                    value = value % value2;
                }
            }else {
                break;
            }
        }
        return value;
    }

    /**计算从index开始的一项<因子>，其中包含以（）为界的子表达式，间接递归调用*/
    private int factor(){
        int value=0;
        if (this.infix.charAt(this.index)=='('){
            //跳过'（'
            this.index++;
            value=this.intValue();
            //通过')'
            this.index++;
        }else {
            value=constant();
        }
        return value;
    }

    /**返回从index开始的一个<常数>*/
    private int constant(){
        int value=0;
        boolean isNegative=false;
        while (this.index<this.infix.length()){
            char ch=this.infix.charAt(this.index);
            if (ch=='+' || ch=='-'){
                if (ch=='-'){
                    isNegative=true;
                }
                index++;
            }
            while (this.index<this.infix.length()){
                ch=this.infix.charAt(this.index);
                if (ch>='0' && ch<='9'){
                    value=value*10+(int)(ch-48);
                    index++;
                }else {
                    break;
                }
            }
            if (isNegative){
                value=0-value;
            }
            return value;
        }
        throw new NumberFormatException("\""+infix.substring(this.index-1)+"\"不能转化成整数！");
    }
}
