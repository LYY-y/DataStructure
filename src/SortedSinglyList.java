public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T> {
    /**构造空排序单链表*/
    public SortedSinglyList() {
        super();
    }

    /**构造，将values数组所有对象按值插入*/
    public SortedSinglyList(T[] values) {
        super();
        for (int i=0; i<values.length; i++){
            this.insert(values[i]);
        }
    }

    /**深拷贝构造方法，调用父类同参数的构造方法*/
    public SortedSinglyList(SortedSinglyList<T> list) {
        super(list);
    }

    /**重载深拷贝构造方法，由单链表构造排序单链表*/
    public SortedSinglyList(SinglyList<T> list) {
        super();
        Node<T> listNode=list.head.next;
        while (listNode!=null){
            this.insert(listNode.data);
            listNode=listNode.next;
        }
    }

    @Override
    public void set(int i, T x) {
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }

    @Override
    public Node<T> insert(int i, T x) {
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }

    /**插入x，x!=null，根据x对象大小顺序查找确定插入位置，插入在等值结点之前
     * 返回插入结点，O（n），覆盖父类的insert(x)方法*/
    @Override
    public Node<T> insert(T x) {
        if (x==null){
            throw new NullPointerException();
        }
        Node<T> self=this.head;
        while (self.next!=null && x.compareTo(self.next.data)>0){
            self=self.next;
        }
        self.next=new Node<T>(x,self.next);
        return self.next;
    }

    /**查找返回首先与key相等元素结点，查找不成功返回null*/
    @Override
    public Node<T> search(T key) {
        if (key==null){
            throw new NullPointerException("key=null");
        }
        Node<T> front=this.head;
        while (front.next!=null && key.compareTo(front.next.data)>=0){
            front=front.next;
            if (key.compareTo(front.data)==0){
                return front;
            }
        }
        return null;
    }

    /**插入不重复元素，查找不成功时按值插入*/
    @Override
    public Node<T> insertDifferent(T x) {
        if (x==null){
            throw new NullPointerException();
        }
        Node<T> front=this.head;
        while (front.next!=null && x.compareTo(front.next.data)>=0){
            front=front.next;
            if (x.compareTo(front.data)==0){
                System.out.print("x="+x+"重复，无法插入！");
                return null;
            }
        }
        front.next=new Node<T>(x,front.next);
        return front.next;
    }

    /**删除首个与key元素相等元素结点，返回被删除元素；查找不成功返回null*/
    @Override
    public T remove(T key) {
        if (key==null){
            throw new NullPointerException("key=null");
        }
        Node<T> front=this.head;
        while (front.next!=null && key.compareTo(front.next.data)>=0){
            if (key.compareTo(front.next.data)==0){
                T removeNode=front.next.data;
                front.next=front.next.next;
                return removeNode;
            }
            front=front.next;
        }
        return null;
    }

    /**将list中所有元素插入到this单链表，不改变list，集合并。覆盖*/
    @Override
    public void addAll(SinglyList<T> list) {
        Node<T> listNode=list.head.next;
        while (listNode!=null){
            this.insert(listNode.data);
            listNode=listNode.next;
        }
    }


}
