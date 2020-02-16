package Chapter2;

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
        int xIndex=termstr.indexOf("x");
        int yIndex=termstr.indexOf("y");
        int xExepIndex=termstr.indexOf("^");
        int yExepIndex=termstr.indexOf("^",yIndex);

        boolean isExistX= (xIndex!=-1);
        boolean isExistY= (yIndex!=-1);
        boolean isOnlyCoef= (!isExistX && !isExistY);
        boolean isCoefEqualsOne=((isExistX && xIndex==0) || (isExistY && yIndex==0));
        boolean isXexpEqualsOne=(isExistX && xExepIndex!=(xIndex+1));
        boolean isYexpEqualsOne=(isExistY && yExepIndex!=(yIndex+1));

        if (isOnlyCoef){
            this.yexp=0;
        }else {
            if (isExistX && isExistY){
                if (isCoefEqualsOne){
                    this.coef=1;
                }else {
                    this.coef=Integer.parseInt(termstr.substring(0,xIndex));
                }
                if (isXexpEqualsOne){
                    this.xexp=1;
                }else {
                    this.xexp=Integer.parseInt(termstr.substring(xExepIndex+1,yIndex));
                }
            }else {
                if (isExistY){
                    if (isCoefEqualsOne){
                        this.coef=1;
                    }else {
                        this.coef=Integer.parseInt(termstr.substring(0,xIndex));
                    }
                    if (isYexpEqualsOne){
                        this.yexp=1;
                    }else {
                        this.yexp=Integer.parseInt(termstr.substring(yExepIndex+1));
                    }

                }else {
                    this.yexp=0;
                }
            }
            if (isExistY){
                if (isYexpEqualsOne){
                    this.yexp=1;
                }else {
                    this.yexp=Integer.parseInt(termstr.substring(yExepIndex+1));
                }
            }else {
                this.yexp=0;
            }
        }



    }

    /**返回一项对应的“系数x^指数y^指数”的省略形式字符串，省略规则同TermX类*/
    @Override
    public String toString(){
        String string=super.toString();
        boolean isExistY=(this.yexp!=0);
        boolean isYexpEqualsOne=(this.yexp==1);
        if (isExistY){
            if (isYexpEqualsOne){
                string+="y";
            }else {
                string+="y^"+this.yexp;
            }
        }
        return string;
    }

    /**按x、y指数比较大小，先比较x指数，若x指数相同，再比较y指数。重载父类同名方法*/
    public int compareTo(TermXY term) {
        if (this.xexp==term.xexp){
            if (this.yexp==term.yexp){
                return 0;
            }else {
                return this.yexp>term.yexp ? 1 : -1;
            }
        }
        return this.xexp>term.xexp ? 1 : -1;
    }

    /**按系数、x指数、y指数比较相等，覆盖*/
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj instanceof TermXY){
            return this.coef==((TermXY) obj).coef && this.xexp==((TermXY) obj).xexp && this.yexp==((TermXY) obj).yexp;
        }
        return false;
    }


}
