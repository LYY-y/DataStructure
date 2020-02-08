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
        super(list);
    }

    public SortedCirDoublyList(SortedCirDoublyList<T> list) {
        super();
        DoubleNode<T> listNode=list.head.next;
        while (listNode!=this.head){
            this.insert(listNode.data);
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

        super.addAll(list);
    }


}
