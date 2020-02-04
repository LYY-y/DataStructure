public class SinglyList_reverse{
    /**构造反序单链表，由values数组提供元素。返回值类型前声明类型参数T
     * 采用头插入，单链表元素次序与数组元素次序相反*/
    public static <T>SinglyList<T> createReverse(T[] values){
        SinglyList<T> ReverseSinglyList=new SinglyList<T>();
        Node<T> front=ReverseSinglyList.head;
        for (int i=0; i<values.length; i++){
            front.next=new Node<T>(values[i],front.next);
        }
        return ReverseSinglyList;
    }

    public static <T>void reverse(SinglyList<T> list){
        
    }


}
