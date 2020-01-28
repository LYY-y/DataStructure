//依次用一维数组和二维数组构造杨辉三角
public class Test1_3 {
    public int[] PascalTriangle(int row){
        int total=(int)(0.5*(1+row)*row);
        int[] pascalTriangle=new int[total];
        pascalTriangle[0]=pascalTriangle[1]=pascalTriangle[2]=1;
        for (int i=1; i<=row; i++) {
            //rowLeft=(1+(i-1))*(i-1)*0.5
            int rowLeft = (int) (i * (i - 1) * 0.5);
            int rowRight = (int) (rowLeft + i - 1);
            //lastRowLeft=(1+(i-2))*(i-2)*0.5
            int lastRowLeft = (int) ((i - 1) * (i - 2) * 0.5);
            //每行个数少于i个
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    pascalTriangle[rowLeft] = 1;
                    pascalTriangle[rowRight] = 1;
                } else {
                    pascalTriangle[rowLeft + j] = pascalTriangle[lastRowLeft] + pascalTriangle[lastRowLeft + 1];
                    lastRowLeft++;
                }
            }
        }

        for (int x:pascalTriangle){
            System.out.print(x+"  ");
        }
        System.out.println();
        return pascalTriangle;
    }

    public void printPascalTriangleOne(int row){
        int[] pascalTriangle=PascalTriangle(row);
        for (int i=1; i<=row; i++){
            for (int j = 0; j < row-i; j++){
                System.out.print(" ");
            }
            int left=(int)(i * (i - 1) * 0.5);
            for (int k=0; k<i; k++){
                System.out.print(pascalTriangle[left]+" ");
                left++;
            }
            System.out.println();
        }
    }

    public void printPascalTriangleTwo(int row){
        int[][] pascalTriangle=new int[row][row];
        pascalTriangle[0][0]=pascalTriangle[1][0]=pascalTriangle[1][1]=1;
        for (int r=0; r<row; r++){
            for (int j = 0; j < row-r-1; j++){
                System.out.print(" ");
            }
            for (int c=0; c<=r; c++){
                if (c==0 || c==r){
                    pascalTriangle[r][0]=pascalTriangle[r][c]=1;
                    System.out.print(pascalTriangle[r][c]+" ");
                }else {
                    pascalTriangle[r][c]=pascalTriangle[r-1][c-1]+pascalTriangle[r-1][c];
                    System.out.print(pascalTriangle[r][c]+" ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        new Test1_3().PascalTriangle(8);
        System.out.println("用一维数组输出如下：");
        new Test1_3().printPascalTriangleOne(8);
        System.out.println("用二维数组输出如下：");
        new Test1_3().printPascalTriangleTwo(8);

    }

}

