/**单链表类*/
public class SinglyList<T> extends Object {
    /**头指针，指向单链表的头结点*/
    public Node<T> head;

    public SinglyList() {
        this.head=new Node<T>();
    }

    public SinglyList(T[] values){
        this();
        Node<T> rear=this.head;
        for (int i=0; i<values.length; i++){
            rear.next=new Node<T>(values[i],null);
            rear=rear.next;
        }
    }

    /**判断单链表是否空*/
    public boolean isEmpty(){
        return this.head.next==null;
    }

    /**存取*/
    /**返回第i个元素，0<=i<表长度。若i越界，则返回null。O(n)*/
    public T get(int i){
        Node<T> p=this.head.next;
        for (int k=0; p!=null && k<i; k++){
            p=p.next;
        }
        if (i>0 && p!=null){
            return p.data;
        }
        return null;
    }

    /**设置第i个元素为x，0<=i<表长度，x!=null*/
    public void set(int i, T x){
        if (x==null){
            throw new NullPointerException();
        }
        if (i<0){
            throw new java.lang.IndexOutOfBoundsException();
        }
        Node<T> p=this.head;
        for (int k=0; k<i && p!=null; k++){
            p=p.next;
        }
        p.data=x;
    }
}
