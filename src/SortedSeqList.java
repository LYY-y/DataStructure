/**排序顺序表类（升序）*/
public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    public SortedSeqList() {
        super();
    }

    public SortedSeqList(int length) {
        super(length);
    }

    public SortedSeqList(T[] values) {
        super(values.length);
        for (int i=0; i<values.length; i++){
            this.insert(values[i]);
        }
    }




    /**插入x，根据x对象大小顺序查找确定插入位置，插入在等值节点之前，返回x序号
     * 调用T 的CompareTo（）方法比较对象大小 P31*/
    @Override
    public int insert(T x) {
        int i=0;
        if (this.isEmpty()){
            return super.insert(x);
        }
        for (i=0; i<this.n; i++){
            if (x.compareTo(this.get(i))<=0){
                break;
            }
        }
        this.n++;
        return super.insert(i,x);
    }

    /**插入不重复元素。查找不成功时，按值插入*/
    @Override
    public int insertDifferent(T x){
        return super.search(x)==-1 ? this.insert(x) : -1;
    }

    /**不支持父类的方法，将其覆盖并抛出异常*/
    @Override
    public void set(int i, T x){
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }

    /**不支持父类的方法，将其覆盖并抛出异常*/
    @Override
    public int insert(int i, T x) {
        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }

    public static void main(String[] args){
        Integer[] values={10,80,50};
        SeqList<Integer> seqList=new SeqList<Integer>(values);
        //SortedSeqList<Integer> sortedSeqList=new SortedSeqList<Integer>(values);
        seqList.insert(0,10);
        seqList.insert(40);
        //sortedSeqList.insert(40);
        System.out.println("seqList:"+seqList.toString());
       // System.out.println("sortedSeqList:"+sortedSeqList.toString());
       // sortedSeqList.insert(0,90);
    }
}
