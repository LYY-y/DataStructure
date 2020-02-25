package Chapter5;

import Chapter2.Addible;
import Chapter2.Multipliable;

public class Triple implements Comparable<Triple>, Addible<Triple>, Multipliable<Triple> {
    int row;
    int column;
    int value;

    public Triple(int row, int column, int value) {
        if (row>=0 && column>=0) {
            this.row = row;
            this.column = column;
            this.value = value;
        }else {
            throw new IllegalArgumentException("行、列号不能为负数：row="+row+", column="+column);
        }
    }

    public Triple(Triple triple) {
        this(triple.row,triple.column,triple.value);
    }

    @Override
    public String toString() {
        return "("+this.row+"，"+this.column+"，"+this.value+")";
    }

    /**根据行、列位置比较三元组对象大小，与元素值无关，约定三元组排序顺序*/
    @Override
    public int compareTo(Triple triple) {
        if (this.row == triple.row){
            if (this.column==triple.column){
                return 0;
            }
            return this.column < triple.column ? -1 : 1;
        }
        return this.row < triple.row ? -1 : 1;
    }

    /**比较三元组是否相等，比较位置和元素值*/
    @Override
    public boolean equals(Object obj) {
        if (this.compareTo((Triple) obj)==0 && this.value==((Triple) obj).value){
            return true;
        }
        return false;
    }

    @Override
    public void add(Triple term) {
        if (this.compareTo(term)==0){
            this.value+=term.value;
        }else {
            throw new IllegalArgumentException("两元素位置不同，无法相加！");
        }
    }

    @Override
    public boolean removeable() {
        return this.value==0;
    }


    /**返回矩阵对称位置的三元组*/
    public Triple toSymmetry(){
        return new Triple(this.column,this.row,this.value);
    }

    /**未实现以下*/
    @Override
    public Triple plus(Triple data) {
        return null;
    }

    /**未实现以下*/
    @Override
    public Triple mul(Triple x) {
        return null;
    }
}
