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
        if (i>=0 && p!=null){
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
        Node<T> p=this.head.next;
        for (int k=0; k<i && p!=null; k++){
            p=p.next;
        }
        p.data=x;
    }

    /**返回单链表长度，O（n）*/
    public int size(){
        Node<T> p=this.head.next;
        for (int i=1; ; i++){
            p=p.next;
            if ( p==null){
                return i;
            }
        }
    }

    /**返回单链表所有元素的描述字符串，形式为（，）。覆盖Object类的toString方法。O（n）*/
    @Override
    public String toString() {
        String string=this.getClass().getName()+"（";
        for (int i=0; i<this.size(); i++){
            if (i==this.size()-1){
                string+=this.get(i).toString();
                break;
            }
            string+=this.get(i).toString()+"，";
        }
        string+="）";
        return string;
    }

    /**插入
     * 插入作为第i个元素，x!=null，返回插入结点
     * 对序号i采取容错措施，若i<0，则插入x在最前；若i>n，则插入x在最后。O（n）*/
    public Node<T> insert(int i, T x){
        if (i<0){
            i=0;
        }
        if (i>this.size()-1){
            i=this.size();
        }
        Node<T> front=this.head.next;
        for (int k=0; k<i; k++){
            front=front.next;
        }
    }
}
