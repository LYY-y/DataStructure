package Chapter5;

import Chapter2.Node;
import Chapter2.PolySinglyList;
import Chapter2.SeqList;
import Chapter2.SortedSinglyList;

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
            this.set(triples[i]);
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
        this.set(new Triple(i,j,x));
    }

    /**以三元组triple设置矩阵元素*/
    public void set(Triple triple){
        int triRow=triple.row;
        int triCol=triple.column;
        if (triRow>=0 && triCol>=0 && triRow<this.rows && triCol<this.columns){
            SortedSinglyList<Triple> link=this.rowList.get(triRow);
            if (triple.value==0){
                link.remove(triple);
            }else {
                Node<Triple> p=link.search(triple);
                if (p!=null){
                    p.data.value=triple.value;
                }else {
                    link.insert(triple);
                }
            }
        }else {
            throw new IndexOutOfBoundsException("triRow="+triRow+", triCol="+triCol);
        }
    }

    /**返回矩阵第i行第j列元素，若越界则抛出异常。查找成功返回元素值，否则返回0*/
    public int get(int i, int j){
        if (i<0 || j<0 || i>=this.rows || j>=this.columns){
            throw new IndexOutOfBoundsException("i="+i+", j="+j);
        }
        Node<Triple> p=this.rowList.get(i).search(new Triple(i,j,0));
        if (p!=null){
            return p.data.value;
        }else {
            return 0;
        }
    }

    /**返回稀疏矩阵三元组行的单链表描述字符串*/
    @Override
    public String toString(){
        String string = "";
        for (int i=0; i<this.rows; i++){
            string += i +"->"+ this.rowList.get(i).toString()+"\n";
        }
        return string;
    }

    /**输出矩阵*/
    public void printMatrix(){
        System.out.println("矩阵"+this.getClass().getName()+"("+this.rows+"*"+this.columns+")：");
        SortedSinglyList link;
        for (int i=0; i<this.rows; i++){
            link=this.rowList.get(i);
            Node<Triple> p=link.head.next;
            for ( int j=0; j<this.columns; j++){
                 if (p!=null && j==p.data.column){
                    System.out.print(String.format("%4d",p.data.value));
                    p=p.next;
                    continue;
                }
                System.out.print(String.format("%4d",0));
            }
            System.out.println();
        }
    }

    /**设置矩阵为m行n列。若m指定行数较大，则将行指针顺序表扩容，使用原各行单链表*/
    public void setRowsColumns(int m, int n){
        if (m<0 || n<0){
            throw new IllegalArgumentException("矩阵行列数不能<=0，m="+m+"，n="+n);
        }
        if (m>this.rows){
            for (int i=this.rows; i<m; i++){
                this.rowList.insert(new PolySinglyList<Triple>());
            }
            this.rows=m;
            this.columns=n;
        }
    }

    /**当前矩阵与matrix矩阵相加，this+=matrix*/
    public void addAll(LinkedMatrix matrix){
        if (this.rows==matrix.rows && this.columns==matrix.columns){
            for (int i=0; i<this.rows; i++){
                this.rowList.get(i).addAll(matrix.rowList.get(i));
            }
        }else {
            throw new IllegalArgumentException("两个矩阵阶数不同，无法相加！");
        }
    }

    /**比较两个矩阵是否相等，条件：行、列数相同，所有位置相同的对应元素值相同*/
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj instanceof LinkedMatrix) {
            LinkedMatrix objMatrix = (LinkedMatrix) obj;
            if (this.rows == objMatrix.rows && this.columns == objMatrix.columns) {
                return this.rowList.equals(objMatrix.rowList);
            }
        }
        return false;
    }
}
