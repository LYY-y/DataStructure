public class Matrix {
    private int row;
    private int column;
    private int[][] matrixArr;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int[][] getMatrix() {
        return matrixArr;
    }

    public void setMatrix(int[][] matrix) {
        this.matrixArr = matrix;
    }

    public Matrix(int row, int column) {
        setRow(row);
        setColumn(column);
        setMatrix(new int[row][column]);
        System.out.println("矩阵如下：");
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                matrixArr[i][j]=(int)(Math.random()*10);
                System.out.print(matrixArr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public Matrix() {
    }

    public Matrix add(Matrix matrix1, Matrix matrix2){
        int[][] matrix1Arr1=matrix1.matrixArr;
        int[][] matrix1Arr2=matrix2.matrixArr;
        int[][] matrixResult=new int[matrix1.getRow()][matrix1.getColumn()];

        System.out.println("矩阵加法：");

        for (int i=0; i<matrixResult.length; i++){
            for (int j=0; j<matrixResult[i].length; j++){
                matrixResult[i][j]=matrix1Arr1[i][j]+matrix1Arr2 [i][j];
                System.out.print(matrixResult[i][j]+" ");
            }
            System.out.println();
        }
        return convert(matrixArr);
    }

    public static Matrix convert(int[][] matrixArr){
        Matrix matrix=new Matrix();
        matrix.matrixArr=matrixArr;
        return matrix;
    }

    public Matrix multiply(Matrix matrix1, Matrix matrix2){
        int[][] matrixArr1=matrix1.matrixArr;
        int[][] matrixArr2=matrix2.matrixArr;
        int[][] matrixResult=new int[matrix1.getRow()][matrix2.getColumn()];

        System.out.println("矩阵乘法：");

        for (int row1=0; row1<matrix1.getRow(); row1++){
            for (int column2=0; column2<matrix2.getColumn(); column2++){
                int sum=0;
                for (int column1=0; column1<matrix1.getColumn(); column1++){
                    sum=sum+matrixArr1[row1][column1]*matrixArr2[column1][column2];
                    if (column1==matrix1.getColumn()-1){
                        matrixResult[row1][column2]=sum;
                        System.out.print(matrixResult[row1][column2]+" ");
                    }
                }
            }
            System.out.println();
        }
        return convert(matrixArr);
    }

    public Matrix transpose(Matrix matrix){
        int[][] preMatrixArr=matrix.getMatrix();
        int preRow=matrix.getRow();
        int preColumn=matrix.getColumn();
        int[][] matrixArr=new int[preColumn][preRow];

        System.out.println("矩阵转置后如下：");

        for (int row=0; row<preColumn; row++){
            for (int column=0; column<preRow; column++){
                matrixArr[row][column]=preMatrixArr[column][row];
                System.out.print(matrixArr[row][column]+" ");
            }
            System.out.println();
        }
        return convert(matrixArr);
    }
}
