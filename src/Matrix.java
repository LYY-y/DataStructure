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
        this.row=row;
        this.column=column;
        this.matrixArr=new int[row][column];
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
        int[][] matrixResult=new int[matrix1.row][matrix1.column];

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
        int[][] matrix1Arr1=matrix1.matrixArr;
        int[][] matrix1Arr2=matrix2.matrixArr;
        int[][] matrixResult=new int[matrix1.row][matrix2.column];

        System.out.println("矩阵乘法：");

        for (int i=0; i<matrixResult.length; i++){
            for (int j=0; j<matrixResult[i].length; j++){
                matrixResult[i][j]=matrixResult[i][j]+matrix1Arr1[i][j]*matrix1Arr2[j][i];
                System.out.print(matrixResult[i][j]+" ");
            }
            System.out.println();
        }
        return convert(matrixArr);
    }
}
