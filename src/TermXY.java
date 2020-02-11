/**二元多项式的一项*/
public class TermXY extends TermX{
    /**y指数*/
    protected int yexp;

    /**构造一项*/
    public TermXY(int coef, int xexp, int yexp) {
        super(coef, xexp);
        this.yexp=yexp;
    }

    /**以“系数x^指数y^指数”的省略形式构造二元多项式的一项，省略规则同TermX类*/
    public TermXY(String termstr) {
        super(termstr);
    }

    /**返回一项对应的“系数x^指数y^指数”的省略形式字符串，省略规则同TermX类*/
    @Override
    public String toString(){
        return "";
    }

    /**按x、y指数比较大小，先比较x指数，若x指数相同，再比较y指数。重载父类同名方法*/
    @Override
    public int compareTo(TermX termX) {
        return super.compareTo(termX);
    }

    /**按系数、x指数、y指数比较相等，覆盖*/
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
