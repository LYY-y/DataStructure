package ExperimentalReport;

import Chapter5.Matrix;

public class Report3 {
//    1.在矩阵Matrix类中增加以下成员方法，并讨论时间复杂度：
//      （1）public boolean equals(Matrix mat)		//比较矩阵是否相等
//		（2）public boolean isSymmetric()		//判断是否为对称矩阵
//		（3）public Matrix multi(Matrix mat) 	//返回与this与mat相乘后的矩阵，不改变this
//		（4）public int saddlePoint()			//返回矩阵的鞍点值
    public static void main(String[] args){
        Report3 report3 = new Report3();
        Matrix mat1 = new Matrix(2,2,new int[][]{{1,3},{3,2}});
        Matrix mat2 = new Matrix(2,2,new int[][]{{1,3},{3,2}});
        Matrix mat3 = new Matrix(2,2,new int[][]{{1,4},{3,2}});
        Matrix mat4 = new Matrix(4,4,new int[][]{{1,7,4,1},{4,8,3,6},{1,6,1,2},{0,7,8,9}});
        Matrix mat5 = new Matrix(2,2,new int[][]{{1,7},{4,1}});
//        System.out.println("比较矩阵是否相等：");
//        System.out.println(mat1.toString() + "与" + mat2.toString() + ": " + mat1.equals(mat2));
//        System.out.println(mat1.toString() + "与" + mat3.toString() + ": " + mat1.equals(mat3));
//        System.out.println("是否为对称矩阵：");
//        System.out.println(mat1.toString() + mat1.isSymmetric());
//        System.out.println(mat3.toString() + mat3.isSymmetric());
//        System.out.println("相乘矩阵：");
//        System.out.println(mat1.toString() + "与" + mat3.toString() + "矩阵相乘后: " + mat1.multi(mat3).toString());
        System.out.println("返回矩阵的鞍点值：");
        System.out.println(mat4.toString() + "鞍点值为：" + mat4.saddlePoint()+"\n");
        System.out.println(mat5.toString() + "鞍点值为：" + mat5.saddlePoint());
    }
}
