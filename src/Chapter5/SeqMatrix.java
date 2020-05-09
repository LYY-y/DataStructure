package Chapter5;

import Chapter2.SeqList;

public class SeqMatrix {
    int rows, cols; //稀疏矩阵的行数和列数
    SeqList<Triple> triList;

    public SeqMatrix(){
        this.rows = 0;
        this.cols = 0;
        this.triList = new SeqList<Triple>();
    }

    public SeqMatrix(int m, int n){
        this.rows = m;
        this.cols = n;
        this.triList = new SeqList<Triple>();
    }

    public SeqMatrix(int m){
        this.rows = m;
        this.cols = m;
        this.triList = new SeqList<Triple>();
    }

    public SeqMatrix(int m, int n, Triple[][] value){
        this(m, n);
        //TODO
    }

    public boolean insert(Triple tri){
        return false;
    }
}
