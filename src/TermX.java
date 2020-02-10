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
        this.coef=term.coef;
        this.xexp=term.xexp;
    }

    /**以“系数x^指数”的省略形式构造意愿多项式的一项
     * 省略形式说明：当系数为1或-1且指数>0时，省略1，-1只写符号“-”，如x^2，-x^3
     * 当指数为0时，省略x^0，只写系数；当系数为1时，省略^1，只写x*/
    public TermX(String termstr){
        boolean isNegative=termstr.startsWith("-");
        if(isNegative){
            termstr=termstr.substring(1);
        }
        boolean isXexpEquapsOne=(termstr.indexOf("^")==-1 && termstr.indexOf("x")!=-1);
        boolean isOnlyCoef=(termstr.indexOf("x")==-1);
        boolean isCoefEqualsOne=(termstr.indexOf("x")==0);
        termstr=termstr.replaceAll(" ","");

        if (isOnlyCoef){
            this.coef=Integer.parseInt(termstr);
            this.xexp=0;
        }
        if (isXexpEquapsOne){
            this.xexp=1;
            if (isCoefEqualsOne){
                this.coef=1;
            }else {
                this.coef=Integer.parseInt(termstr.substring(0,termstr.length()-1));
            }
        }else {
            this.coef=Integer.parseInt(termstr.substring(0,termstr.indexOf("x")));
            this.xexp=Integer.parseInt(termstr.substring(termstr.indexOf("^")+1));
        }
        if (isNegative){
            this.coef=0-this.coef;
        }
    }

    /**返回一项对应的“系数x^指数”的省略形式字符串，省略形式说明同TermX(String)*/
    @Override
    public String toString(){
        boolean isNegative=(this.coef<0);
        boolean isXexpEquapsOne=(this.xexp==1);
        boolean isOnlyCoef=(this.coef==0);
        boolean isCoefEqualsOne=(this.coef==1 || this.coef==-1);

        String string="";
        if (isOnlyCoef){
            return string+=this.coef;
        }
        if (isXexpEquapsOne){
            if (isCoefEqualsOne){
                if (isNegative){
                    return string+="-x";
                }
                return string+="x";
            }
            return string=string+this.coef+"x";
        }else {
            return string=string+this.coef+"x^"+this.xexp;
        }
    }

    /**按系数和指数比较两项是否相等*/
    @Override
    public boolean equals(Object obj){
        return false;
    }

    /**按x指数比较两项大小，实现Comparable<T>接口*/
    @Override
    public int compareTo(TermX o) {
        return 0;
    }

    /**若指数相同，则系数相加；实现Addible<T>接口*/
    @Override
    public void add(TermX termX) {

    }

    /**若系数为0，则删除元素；实现Add ible<T>接口*/
    @Override
    public boolean removeable() {
        return false;
    }


}
