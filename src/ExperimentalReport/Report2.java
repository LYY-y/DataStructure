package ExperimentalReport;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Report2 {
    //1.使用一个栈，将十进制装换为二进制或十六进制；使用一个栈，将十进制装换为二进制或十六进制
    public String convertDecimal(int value, int radix){
        String res = "";
        Stack<String> stack = new Stack<String>();
        while (value > 0) {
            //获取个位
            int bit = value & (radix - 1);
            if (bit <= 9){
                stack .push(""+bit);
            }else {
                stack.push(""+(char)(bit+'a'-10));
            }
            value /= radix;
        }
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    //2、布线问题：印刷电路板将布线区域划分为n×m个方格阵列。布线问题要求确定连接方格a的中点到方格b的中点的最短布线方案
    //在电路板中0代表可通过，-1代表障碍,-2表示开始a，-3表示终点b
    //用1、2、3、4代表父节点在当前节点的下、左、上、右方向
    public List<List> findShortestPath(int[][] gird){
        int row = gird.length;
        int col = gird[0].length;
        int[] start = new int[2];
        //找到开始点start
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (gird[i][j] == -2){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        //按照上、右、下、左方向进行搜索的方向坐标
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        //表示父节点在当前节点的方向
        int[] dir = new int[]{1,2,3,4};
        boolean haveEnd = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int r = 0;
        int c = 0;
        while (!queue.isEmpty()){
            int[] p = queue.poll();
            r = p[0];
            c = p[1];
            for (int i = 0; i < 4; i++){
                int cur_r = r + dr[i];
                int cur_c = c + dc[i];
                if (cur_r >= 0 && cur_r < row && cur_c >= 0 && cur_c < col) {
                    if (gird[cur_r][cur_c] == -3) {
                        r = cur_r;
                        c = cur_c;
                        gird[cur_r][cur_c] = dir[i];
                        haveEnd = true;
                        queue.clear();
                        break;
                    }
                    if (gird[cur_r][cur_c] == 0){
                        queue.add(new int[]{cur_r, cur_c});
                        //标记已经过的线路
                        gird[cur_r][cur_c] = dir[i];
                    }
                }
            }
        }

        if (haveEnd) {
            //从结束点回溯到初始点
            Stack<int[]> stack = new Stack<int[]>();
            stack.push(new int[]{r, c});
            while (gird[r][c] != -2) {
                int d = gird[r][c];
                if (d == 1) {
                    r += 1;
                } else if (d == 2) {
                    c -= 1;
                } else if (d == 3) {
                    r -= 1;
                } else if (d == 4) {
                    c += 1;
                }
                stack.push(new int[]{r, c});
            }
            // 返回结果
            List<List> res = new LinkedList<>();
            while (!stack.isEmpty()) {
                int[] temp = stack.pop();
                List tempList = new LinkedList();
                for (int i = 0; i < temp.length; i++) {
                    tempList.add(temp[i]);
                }
                res.add(tempList);
            }
            return res;
        }else {
            System.out.println("没有找到b点");
            return null;
        }
    }


    //3.用递归算法实现角谷猜想的计算过程
    //描述：所谓角谷猜想，是指对于任意一个正整数，如果是奇数，则乘3加1，如果是偶数，则除以2，得到的结果再按照上述规则重复处理，最终总能够得到1。如，假定初始整数为5，计算过程分别为16、8、4、2、1。
    //程序要求输入一个整数，将经过处理得到1的过程输出来。
    public void CollatzConjecture(int val){
        if (val == 1){
            System.out.println("End");
            return;
        }
        if ((val & 1) == 1){
            System.out.print(val+"*3+1 = ");
            val = val * 3 + 1;
            System.out.println(val);
        }else {
            System.out.print(val+"/2 = ");
            val = val >> 1;
            System.out.println(val);
        }
        CollatzConjecture(val);
    }

    public static void main(String[] args){
        Report2 report2 = new Report2();
//        System.out.println("将10转换成二进制："+report2.convertDecimal(10,2));
//        System.out.println("将10转换成十六进制："+report2.convertDecimal(10,16));

//        int[][] grid = new int[][]{{0,0,1,0,0,0,0},{0,0,1,1,0,0,0},{0,-2,0,0,1,0,0},{0,0,0,1,1,-3,0},{1,0,0,0,1,0,0},{1,1,1,0,0,0,0},{1,1,1,0,0,0,0}};
//        System.out.println("最短布线方案为：" + report2.findShortestPath(grid));

        System.out.println("输入5：");
        report2.CollatzConjecture(5);
        System.out.println("输入1：");
        report2.CollatzConjecture(1);
    }
}
