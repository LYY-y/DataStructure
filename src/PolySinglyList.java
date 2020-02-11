/**多项式排序单链表，继承排序单链表类，提供排序单链表的多项式相加运算
 * T或T的某个祖先类必须实现Comparable<T>接口；T必须实现Addible<T>可相加接口*/
public class PolySinglyList<T extends Comparable<? super T> & Addible<T>> extends SortedSinglyList<T>{
    public PolySinglyList() {
        super();
    }

    /**由项数组指定多项式各项值*/
    public PolySinglyList(T terms[]) {
        super(terms);
    }

    /**深拷贝，复制所有结点，没有复制对象*/
    public PolySinglyList(PolySinglyList<T> list) {
        super(list);
    }

    /**多项式相加，this+=list功能，不改变list*/
    public void addAll(PolySinglyList<T> list) {
        Node<T> selfFront=this.head;
        Node<T> selfNode=selfFront.next;
        Node<T> listNode=list.head.next;
        while (selfNode!=null && listNode!=null){
            if (selfNode.data.compareTo(listNode.data)==0){
                selfNode.data.add(listNode.data);
                if (selfNode.data.removeable()){
                    selfFront.next=selfFront.next.next;
                    selfNode=selfFront.next;
                    listNode=listNode.next;
                    continue;
                }
                selfFront=selfFront.next;
                selfNode=selfNode.next;
                listNode=listNode.next;
            }else if (selfNode.data.compareTo(listNode.data)<0){
                selfFront=selfFront.next;
                selfNode=selfNode.next;
            }else if (selfNode.data.compareTo(listNode.data)>0){
                selfFront.next=new Node<T>(listNode.data,selfNode);
                selfFront=selfFront.next;
                listNode=listNode.next;
            }
        }
        while (listNode!=null){
            selfFront.next=new Node<T>(listNode.data,selfNode);
            listNode=listNode.next;
            selfFront=selfFront.next;
        }
    }
}
