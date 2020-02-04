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
            throw new NullPointerException("x=null");
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
        if (p==null){
            return 0;
        }
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
        Node<T> p=this.head.next;
        String string=this.getClass().getName()+"（";
        for (int i=0; p!=null; i++){
            if (p.next==null){
                string+=this.get(i).toString();
                break;
            }
            string+=this.get(i).toString()+"，";
            p=p.next;
        }
        return string+="）";
    }

    /**插入
     * 插入作为第i个元素，x!=null，返回插入结点
     * 对序号i采取容错措施，若i<0，则插入x在最前；若i>n，则插入x在最后。O（n）*/
    public Node<T> insert(int i, T x){
        if (x==null){
            throw new NullPointerException("x=null");
        }
//使用size（）时间复杂度为O（n）,则花费时间更多
//        int size=this.size();
//        if (i<0){
//            i=0;
//        }
//        if (i>size-1){
//            i=size;
//        }
//        Node<T> front=this.head.next;
//        for (int k=0; k<i-1; k++){
//            front=front.next;
//        }
//        front.next=new Node<T>(x,front.next);
//        return front.next;
        Node<T> front=this.head.next;
        for (int k=0; k<i && front.next!=null; k++){
            front=front.next;
        }
        front.next=new Node<T>(x,front.next);
        return front.next;
    }

    /**在单链表最后添加x对象，O（n）*/
    public Node<T> insert(T x){
        return this.insert(Integer.MAX_VALUE,x);
    }

    /**删除
     * 删除第i个元素，0<=i<n，返回被删除元素；若i越界，则返回null*/
    public T remove(int i){
        if (i>=0){
            Node<T> front=this.head;
            for (int k=0; k<i && front.next!=null; k++){
                front=front.next;
            }
            if ( front.next!=null){
                T delDate=front.next.data;
                front.next=front.next.next;
                return delDate;
            }
        }
        return null;

    }

    /**删除单链表所有元素*/
    public void clear(){
        this.head.next=null;
    }

    /**查找返回首个与key相等元素结点，查找不成功返回null*/
    public Node<T> search(T key){
        if (key==null){
            throw new NullPointerException("key=null");
        }
        Node<T> p=this.head.next;
        for (int i=0; p!=null; i++){
            if (key.equals(p.data)){
                return p;
            }
            p=p.next;
        }
        return null;
    }

    /**判断是否包含关键字为key元素*/
    public boolean contains(T key){
        return this.search(key)==null ? false : true;
    }

    /**插入不重复元素，查找不成功时尾插入*/
    public Node<T> insertDifferent(T x){
        return this.contains(x) ? null : this.insert(x);
    }

    /**删除首个与key相等元素，返回被删除元素；查找不成功返回null*/
    public T remove(T key){
        if (key==null){
            throw new NullPointerException("key=null");
        }
        Node<T> p=this.head.next;
        for (int i=0; p!=null; i++){
            if (key.equals(p.data)){
                return this.remove(i);
            }
            p=p.next;
        }
        return null;
    }




}
