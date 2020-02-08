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
        super(list);
    }

    @Override
    public void set(int i, T x) {
        super.set(i, x);
    }

    @Override
    public DoubleNode<T> insert(int i, T x) {
        return super.insert(i, x);
    }

    @Override
    public DoubleNode<T> search(T key) {
        return super.search(key);
    }

    @Override
    public DoubleNode<T> insertDifferent(T x) {
        return super.insertDifferent(x);
    }

    @Override
    public void addAll(CirDoublyList<T> list) {
        super.addAll(list);
    }

    /**插入x，x!=null，根据x对象大小顺序查找确定插入位置，插入在等值结点之前
     * 返回插入结点。O（n）。覆盖父类的insert(x)方法*/
    @Override
    public DoubleNode<T> insert(T x) {
        if (x==null){
            throw new NullPointerException("x==null");
        }
        if (x.compareTo(this.head.prev.data)>0 || this.isEmpty()){
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
}
