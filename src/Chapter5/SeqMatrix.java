package Chapter5;

import Chapter2.Node;
import Chapter2.SeqList;
import Chapter2.SortedSinglyList;

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

    public SeqMatrix(int m, int n, Triple[] value){
        this(m, n);
        for (int i = 0; i < value.length; i++){
            this.insert(value[i]);
        }
    }


    public int insert(Triple triple){
        int triRow=triple.row;
        int triCol=triple.column;
        if (triRow>=0 && triCol>=0 && triRow<this.rows && triCol<this.cols){
            if (triple.value==0){
                return -1;
            }else {
                int i = 0;
                while (i < this.triList.size()){
                    Triple tri = this.triList.get(i);
                    if (triple.compareTo(tri) == 0){
                        this.triList.set(i, triple);
                        break;
                    }else if (triple.compareTo(tri) > 0){
                        i++;
                    }else {
                        this.triList.insert(i, triple);
                        return i;
                    }
                }
                this.triList.insert(triple);
                return i;
            }
        }else {
            throw new IndexOutOfBoundsException("triRow="+triRow+", triCol="+triCol);
        }
    }

    @Override
    public String toString(){
        String str = "三元组顺序表：" + this.triList.toString();
        return str;
    }

    public void printMatrix(){
        System.out.println("矩阵"+this.getClass().getName()+"("+this.rows+"*"+this.cols+")：");
        int k = 0;
        Triple tri = this.triList.get(k);
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.cols; j++){
                if (tri != null && tri.row == i && tri.column == j){
                    System.out.print(String.format("%4d", tri.value));
                    tri = this.triList.get(++k);
                }else {
                    System.out.print(String.format("%4d", 0));
                }
            }
            System.out.println();
        }
    }

    //相加到当前矩阵，不存储0元素
    public void add(SeqMatrix mat){
        if (this.rows != mat.rows || this.cols != mat.cols){
            throw new IllegalArgumentException("两个矩阵阶数不同，无法相加！");
        }
        int i = 0, j = 0;
        while (i < this.triList.size() && j < mat.triList.size()){
            Triple self_tri = this.triList.get(i);
            Triple mat_tri = mat.triList.get(j);

            if (self_tri.compareTo(mat_tri) == 0){
                if (self_tri.value + mat_tri.value != 0){
                    this.triList.set(i, new Triple(self_tri.row, self_tri.column, self_tri.value + mat_tri.value));
                }else {
                    this.triList.remove(i);
                }
                j++;
            }else if (self_tri.compareTo(mat_tri) > 0){
                this.triList.insert(i, mat_tri);
                i++;
                j++;
            }else {
                i++;
            }
        }
    }

    //矩阵转置运算，要求最多O（n+t），n为列数，t为非零元个数
    public SeqMatrix transpose(){
        for (int i = 0; i < this.triList.size(); i++){
            int temp = this.triList.get(i).row;
            this.triList.get(i).row = this.triList.get(i).column;
            this.triList.get(i).column = temp;
        }
        Triple[] value = new Triple[triList.size()];
        for (int i = 0; i < value.length; i++){
            value[i] = triList.get(i);
        }
        SeqMatrix tans = new SeqMatrix(this.cols, this.rows, value);
        return tans;
    }
}
