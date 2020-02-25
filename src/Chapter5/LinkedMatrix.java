package Chapter5;

import Chapter2.PolySinglyList;
import Chapter2.SeqList;

/**行的单链表存储的矩阵类*/
public class LinkedMatrix {
    private int rows;
    private int columns;
    SeqList<PolySinglyList<Triple>> rowList;

    /**构造m*n零矩阵*/
    public LinkedMatrix(int m, int n) {
        if (m > 0 && n > 0){
            this.rows=m;
            this.columns=n;
            this.rowList=new SeqList<PolySinglyList<Triple>>();
            for (int i=0; i<m; i++){
                this.rowList.insert(new PolySinglyList<Triple>());
            }
        }else {
            throw new IllegalArgumentException("矩阵行列数不能<=0,m="+m+", n="+n);
        }
    }

    public LinkedMatrix(int m){
        this(m,m);
    }

    public LinkedMatrix(int m, int n, Triple[] triples){
        this(m,n);
        for (int i=0; i<triples.length; i++){

        }
    }

    public int getRows(){
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    /**设置矩阵第i行第j列元素为x*/
    public void set(int i, int j,int x){

    }

    /**以三元组triple设置矩阵元素*/
    public void set(Triple triple){
        int triRow=triple.row;
        int triCol=triple.column;
        if (triRow>0 && triCol>0 && triRow<this.rows && triCol<this.columns){
            S
        }
    }
}
