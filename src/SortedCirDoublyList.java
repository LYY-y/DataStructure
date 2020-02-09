/**排序循环双链表类（升序）*/
public class SortedCirDoublyList<T extends Comparable<? super T>> extends CirDoublyList<T> {
    public SortedCirDoublyList() {
        super();
    }

    public SortedCirDoublyList(T[] values) {
        super();
        for (T t:values){
            this.insert(t);
        }
    }

    public SortedCirDoublyList(CirDoublyList<T> list) {
        super();
        DoubleNode<T> listNode=list.head.next;
        while (listNode!=list.head){
            this.insert(listNode.data);
            listNode=listNode.next;
        }
    }

    public SortedCirDoublyList(SortedCirDoublyList<T> list) {
        super();
        DoubleNode<T> selfNode=this.head;
        DoubleNode<T> listNode=list.head.next;
        while (listNode!=list.head){
            selfNode.next=new DoubleNode<T>(listNode.data,selfNode,this.head);
            selfNode=selfNode.next;
            listNode=listNode.next;
        }
    }

    @Override
    public void set(int i, T x) {
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }

    @Override
    public DoubleNode<T> insert(int i, T x) {
        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }

    /**插入x，x!=null，根据x对象大小顺序查找确定插入位置，插入在等值结点之前
     * 返回插入结点。O（n）。覆盖父类的insert(x)方法*/
    @Override
    public DoubleNode<T> insert(T x) {
        if (x==null){
            throw new NullPointerException("x==null");
        }
        if (this.isEmpty() || x.compareTo(this.head.prev.data)>0){
            return super.insert(x);
        }
        DoubleNode<T> p=this.head.next;
        while (p!=head && x.compareTo(p.data)>=0){
            p=p.next;
        }
        DoubleNode<T> insertNode=new DoubleNode<T>(x,p.prev,p);
        p.prev.next=insertNode;
        p.prev=insertNode;
        return insertNode;
    }

    /**查找，比相等和大小*/
    @Override
    public DoubleNode<T> search(T key) {
        if (key==null){
            throw new NullPointerException("key=null");
        }
        DoubleNode<T> searchNode=this.head.next;
        while (searchNode!=this.head && key.compareTo(searchNode.data)>=0){
            if (key.compareTo(searchNode.data)==0){
                return searchNode;
            }
            searchNode=searchNode.next;
        }
        return null;
    }

    /**值插入*/
    @Override
    public DoubleNode<T> insertDifferent(T x) {
        if (x==null){
            throw new NullPointerException("x==null");
        }
        DoubleNode<T> insertPreNode=this.head.next;
        DoubleNode<T> insertNextNode;
        while (insertPreNode!=this.head && x.compareTo(insertPreNode.data)>=0){
            if (x.compareTo(insertPreNode.data)==0){
                System.out.print("x="+x+",值重复，插入失败！");
                return null;
            }
            insertPreNode=insertPreNode.next;
        }
        return this.insert(x);
    }

    /**插入排序*/
    @Override
    public void addAll(CirDoublyList<T> list) {
        DoubleNode<T> selfNode;
        DoubleNode<T> listNode=list.head.next;
        DoubleNode<T> listNodeNext;
        while (listNode!=list.head){
            selfNode=this.head.next;
            listNodeNext=listNode.next;
            System.out.println(listNodeNext.data);
            while (selfNode!=this.head && selfNode.data.compareTo(listNode.data)<0){
                selfNode=selfNode.next;
            }
            listNode.prev=selfNode.prev;
            listNode.next=selfNode;
            selfNode.prev.next=listNode;
            selfNode.prev=listNode;
            listNode=listNodeNext;
            System.out.println(this.toString());
        }
        list.head.prev.next=this.head;

        System.out.println("this："+this.toString());

        this.head.prev=list.head.prev;

        System.out.println("this："+this.toString());

        list.head.next= list.head;

        System.out.println("this："+this.toString());

        list.head.prev=list.head;

        System.out.println("list："+list.toString());
        System.out.println("this："+this.toString());
    }
}
