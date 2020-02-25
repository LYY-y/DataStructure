package Chapter5;
/**矩阵类*/
public class Matrix {
    private int rows;
    private int columns;
    private int[][] element;

    /**构造m*n零矩阵*/
    public Matrix(int m, int n) {
        if (m<0 || n<0){
            throw new NegativeArraySizeException("m="+m+", n="+n);
        }
        this.element=new int[m][n];
        this.rows = m;
        this.columns=n;
    }

    /**构造n*n零矩阵*/
    public Matrix(int n) {
        this(n,n);
    }

    /**构造m*n矩阵，由value[][]提供元素*/
    public Matrix(int rows, int columns, int[][] value) {
        this(rows,columns);
        for (int i=0; i<value.length && i<rows; i++){
            for (int j=0; j<value[i].length && j<columns; j++){
                this.element[i][j]=value[i][j];
            }
        }
    }

    public int getRows(){
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    /**返回矩阵第i行第j列元素。若越界则抛出序号越界异常*/
    public int get(int i, int j){
        if (i<0 || j<0 || i>=this.rows || j>=this.columns){
            throw new IndexOutOfBoundsException("i="+i+", j="+j);
        }
        return this.element[i][j];
    }

    /**设置矩阵第i行第j列元素。若越界则抛出序号越界异常*/
    public void set(int i, int j, int x){
        if (i<0 || j<0 || i>=this.rows || j>=this.columns){
            throw new IndexOutOfBoundsException("i="+i+", j="+j);
        }
        this.element[i][j]=x;
    }

    @Override
    public String toString(){
        String string="矩阵"+this.getClass().getName()+"("+this.rows+"*"+this.columns+"): \n";
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                string+=String.format("%6d",this.element[i][j]);
            }
            string+="\n";
        }
        return string;
    }

    /**设置矩阵为m行n列，若参数指定行列数比较大，则将矩阵扩容，并复制原矩阵元素*/
    public void setRowsColumns(int m, int n){
        if (m<0 || n<0 ){
            throw new IndexOutOfBoundsException("m="+m+", n="+n);
        }
        if (m>this.element.length || n>this.element.length){
            int[][] sorce=this.element;
            this.element=new int[m][n];
            for (int i=0; i<this.rows; i++){
                for (int j=0; j<this.columns; j++){
                    this.element[i][j]=sorce[i][j];
                }
            }
        }
        this.rows=m;
        this.columns=n;
    }
}
