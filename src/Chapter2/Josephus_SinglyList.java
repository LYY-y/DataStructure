package Chapter2;

public class Josephus_SinglyList {
    public Josephus_SinglyList(int number, int start, int distance) {
        String[] strings=new String[number];
        for (int i=0; i<number; i++){
            strings[i]=(char)(97+i)+"";
        }
        SinglyList<String> singlyList=new SinglyList<String>(strings);
        Node<String> front=singlyList.head;
        for (int j=0; j<start && front!=null; j++){
            front=front.next;
        }
        while (number>1){
            for (int k=1; k<distance;k++){
                front=front.next;
                if (front==null){
                    front=singlyList.head.next;
                }
            }
            if (front.next==null){
                front=singlyList.head;
            }
            System.out.println("被删除的元素为："+front.next.data);
            front.next=front.next.next;
            number--;
        }
        System.out.println("剩余的元素为："+singlyList.toString());
    }


    public static void main(String[] args){
        System.out.println("采用单链表实现：");
        Josephus_SinglyList josephus_singlyList=new Josephus_SinglyList(7,2,3);

    }
}
