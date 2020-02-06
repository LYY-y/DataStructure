/**循环双链表*/
public class CirDoublyList<T> {
    /**头指针*/
    public DoubleNode<T> head;

    /**构造空循环双链表*/
    public CirDoublyList() {
        this.head=new DoubleNode<T>();
        this.head.next=this.head;
        this.head.prev=this.head;
    }
    /**重载构造方法*/
    public CirDoublyList(T[] values){
        this();
        for (T t:values){
            this.insert(t);
        }
    }

    /**重载构造方法，深拷贝*/
    public CirDoublyList(CirDoublyList<T> list){
        this();
        DoubleNode<T> p=this.head.next;
        p.next.prev=p;
        p.prev.next=p;
        DoubleNode<T> listNode=list.head.next;
        while (listNode!=list.head){
            p=new DoubleNode<T>(listNode.data,null,null);
            p=p.next;
            p.next.prev=p;
            p.prev.next=p;
            listNode=listNode.next;
        }
    }

    /**判断循环双链表是否为空*/
    public boolean isEmpty(){
        return this.head.next==this.head;
    }

    /**插入x为第i个元素，x!=null，返回x结点。对i容错，若i<0，则头插入;若i>长度n，则尾插入*/
    public DoubleNode<T> insert(int i, T x){
        if (x==null){
            throw new NullPointerException("x==null");
        }
        DoubleNode<T> front=this.head;
        for (int j=0; front.next!=this.head && j<i; j++){
            front=front.next;
        }
        DoubleNode<T> q=new DoubleNode<T>(x,front,front.next);
        front.next.prev=q;
        front.next=q;
        return q;
    }

    /**尾插入x元素，返回x结点。算法在头结点之前插入，O（1）*/
    public DoubleNode<T> insert(T x){
        if (x==null){
            throw new NullPointerException("x==null");
        }
        DoubleNode<T> p=new DoubleNode<T>(x,this.head.prev,this.head);
        this.head.prev.next=p;
        this.head.prev=p;
        return p;
    }

    /**返回所有元素的描述字符串，元素次序从后往前*/
    public String toPreviousString(){
        String string=this.getClass().getName()+"（";
        DoubleNode<T> p=this.head;
        while (p.prev.prev!=this.head){
            p=p.prev;
            string+=p.data.toString()+"，";
        }
        p=p.prev;
        string+=p.data.toString()+"）";
        return string;
    }

    /**删除最后一个元素，返回被删除元素。若链表空，则返回null*/
    public T removeLast(){
        if (this.head.next==this.head||this.head.prev==this.head){
            return null;
        }
        DoubleNode<T> p=this.head.prev;
        p.prev.next=this.head;
        this.head.prev=p.prev;
        return p.data;
    }
}
