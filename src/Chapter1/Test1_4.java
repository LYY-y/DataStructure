package Chapter1;

//声明矩阵类，构造n阶矩阵，实现矩阵加、乘、转置等运算
public class Test1_4 {
    public static void main(String[] args){
        Matrix matrix1=new Matrix(2,3);
        Matrix matrix2=new Matrix(2,3);
        Matrix matrix3=new Matrix(3,2);
        new Matrix().add(matrix1,matrix2);
        new Matrix().multiply(matrix2,matrix3);
        new Matrix().transpose(matrix1);
    }
}
