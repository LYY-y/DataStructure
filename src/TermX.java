import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**一元多项式的项类*/
public class TermX implements Comparable<TermX>,Addible<TermX> {
    /**系数，x指数（可为正、0），系数也可为double*/
    protected int coef,xexp;

    /**构造一项*/
    public TermX(int coef, int xexp) {
        this.coef = coef;
        this.xexp = xexp;
    }

    /**拷贝构造方法*/
    public TermX(TermX term){
        this(term.coef,term.xexp);
//相当于,上面更优
//        this.coef=term.coef;
//        this.xexp=term.xexp;
    }

    /**以“系数x^指数”的省略形式构造意愿多项式的一项
     * 省略形式说明：当系数为1或-1且指数>0时，省略1，-1只写符号“-”，如x^2，-x^3
     * 当指数为0时，省略x^0，只写系数；当系数为1时，省略^1，只写x*/
    public TermX(String termstr){
        termstr=termstr.replaceAll(" ","");
        boolean isNegative=termstr.startsWith("-");
        if(isNegative || termstr.startsWith("+")){
            termstr=termstr.substring(1);
        }

        int xIndex=termstr.indexOf("x");
        int expIndex=termstr.indexOf("^");

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(termstr);
        boolean isOnlyCoef=(isNum.matches());

        boolean isOnlyExistX= (xIndex!=-1 && termstr.indexOf("y")==-1);
        boolean isXexpEqualsOne=(isOnlyExistX && expIndex!=(xIndex+1));
        boolean isCoefEqualsOne=(isOnlyExistX && xIndex==0);

        if (isOnlyCoef){
            this.coef=Integer.parseInt(termstr);
            this.xexp=0;
        }else {
            if (isOnlyExistX){
                if (isCoefEqualsOne){
                    this.coef=1;
                    if (isXexpEqualsOne){
                        this.xexp=1;
                    }else {
                        this.xexp=Integer.parseInt(termstr.substring(expIndex+1));
                    }
                }else {
                    this.coef=Integer.parseInt(termstr.substring(0,xIndex));
                    if (isXexpEqualsOne){
                        this.xexp=1;
                    }else {
                        this.xexp=Integer.parseInt(termstr.substring(expIndex+1));
                    }
                }
            }
        }
        if (isNegative){
            this.coef=0-this.coef;
        }
    }

    /**返回一项对应的“系数x^指数”的省略形式字符串，省略形式说明同TermX(String)*/
    @Override
    public String toString(){
        boolean isExistX=(this.xexp!=0);
        boolean isExistCoef=(this.coef!=0);
        boolean isNegative=(this.coef<0);
        boolean isXexpEquapsOne=(this.xexp==1);
        boolean isCoefEqualsOne=(this.coef==1 || this.coef==-1);
        String string="";
        if (isExistCoef){
            string += isNegative ? "-" : "+";
            if (!isCoefEqualsOne){
                string+=Math.abs(this.coef);
            }
        }
        if (isExistX){
            string+="x";
            if (!isXexpEquapsOne){
               string+="^"+this.xexp;
            }
        }
        return string;
    }

    /**按系数和指数比较两项是否相等*/
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj instanceof TermX){
            return this.coef==((TermX) obj).coef && this.xexp==((TermX) obj).xexp;
        }
        return false;
    }

    /**按x指数比较两项大小，实现Comparable<T>接口*/
    @Override
    public int compareTo(TermX termX) {
        if (this.xexp==termX .xexp){
            return 0;
        }
        return this.xexp<termX.xexp ? -1 : 1;
    }

    /**若指数相同，则系数相加；实现Addible<T>接口*/
    @Override
    public void add(TermX termX) {
        if (this.compareTo(termX)==0){
            this.coef+=termX.coef;
        }else {
            throw new IllegalArgumentException("指数不同，无法相加");
        }
    }

    /**若系数为0，则删除元素；实现Addible<T>接口*/
    @Override
    public boolean removeable() {
        return this.coef==0;
    }


}
