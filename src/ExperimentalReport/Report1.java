package ExperimentalReport;

import Chapter2.Node;
import Chapter2.SinglyList;

public class Report1 {
    /**对一个任意线性表，选择第一个数据元素为基准，设计存储结构和算法，使得能在O(n)的时间复杂度内完成基于基准的划分，即比基准小的数都在基准的前面，而比基准大的数都在基准的后面。*/
    public SinglyList<Integer> partition(SinglyList<Integer> list){
        if (list.head.next == null){
            return list;
        }
        Node<Integer> s = list.head.next;
        Node<Integer> f = s.next;
        int mark = s.data;
        while (f != null){
            if (mark > f.data){
                s.next = f.next;
                f.next = list.head.next;
                list.head.next = f;
                f = s.next;
            }else {
                s = s.next;
                f = f.next;
            }
        }
        return list;
    }


    public static void main(String[] args){
        Report1 report1 = new Report1();
        SinglyList<Integer> singlyList = new SinglyList<Integer>(new Integer[]{5,1});
        System.out.println("变化前：" + singlyList.toString());
        report1.partition(singlyList);
        System.out.println("变化后：" + singlyList.toString());
    }
}
