package Chapter2;

/**多项式排序单链表，继承排序单链表类，提供排序单链表的多项式相加运算
 * T或T的某个祖先类必须实现Comparable<T>接口；T必须实现Addible<T>可相加接口*/
public class PolySinglyList<T extends Comparable<? super T> & Addible<T>& Multipliable<T>> extends SortedSinglyList<T>{
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

    /**P60 2-10
     * 多项式相加，返回this+list的多项式，不改变this和list，C（x）=A（x）+B（x）
     * 算法不依赖于深拷贝，将this(A)和list(B)中的所有结点合并（相加）到C多项式单链表*/
    public PolySinglyList<T> union(PolySinglyList<T> list){
        PolySinglyList<T> result=new PolySinglyList<>();
        Node<T> resultNode=result.head;
        Node<T> selfNode=this.head.next;
        Node<T> listNode=list.head.next;
        while (selfNode!=null && listNode!=null){
            resultNode.next=new Node<T>(null,null);
            if (selfNode.data.compareTo(listNode.data)==0){
                resultNode.next.data=selfNode.data.plus(listNode.data);
                if (resultNode.next.data.removeable()){
                    selfNode=selfNode.next;
                    listNode=listNode.next;
                    continue;
                }
                selfNode=selfNode.next;
                listNode=listNode.next;
            }else if (selfNode.data.compareTo(listNode.data)<0){
                resultNode.next.data=selfNode.data;
                selfNode=selfNode.next;
            }else if (selfNode.data.compareTo(listNode.data)>0){
                resultNode.next.data=listNode.data;
                listNode=listNode.next;
            }
            resultNode=resultNode.next;
        }
        while (listNode!=null){
            resultNode.next=new Node<T>(null,null);
            resultNode.next.data=listNode.data;
            listNode=listNode.next;
            resultNode=resultNode.next;
        }
        while (selfNode!=null){
            resultNode.next=new Node<T>(null,null);
            resultNode.next.data=selfNode.data;
            selfNode=selfNode.next;
            resultNode=resultNode.next;
        }
        return result;
    }
    /**多项式相乘
     * 存在问题：不相邻的指数相同的项无法合并*/
    public PolySinglyList<T> mulAll(PolySinglyList<T> list){
        PolySinglyList<T> result=new PolySinglyList<>();
        Node<T> resultNode=result.head;
        Node<T> selfNode=this.head.next;
        Node<T> listNode=list.head.next;
        while (selfNode!=null){
            while (listNode!=null){
                resultNode.next=new Node<T>(selfNode.data.mul(listNode.data),null);
                listNode=listNode.next;
                resultNode=resultNode.next;
            }
            listNode=list.head.next;
            selfNode=selfNode.next;
        }
        resultNode=result.head.next;
        while (resultNode.next!=null){
            if (resultNode.data.compareTo(resultNode.next.data)==0){
                resultNode.data=resultNode.data.plus(resultNode.next.data);
                resultNode.next=resultNode.next.next;
            }
            resultNode=resultNode.next;
        }
        return result;
    }
}
