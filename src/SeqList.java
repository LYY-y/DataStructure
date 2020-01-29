import java.util.List;

//顺序表
public class SeqList<T> extends Object {
    /** 对象数组存储顺序表的数据元素，保护成员 */
    protected Object[] element;
    /** 顺序表元素个数，0<=n<=element.length */
    protected int n;

    /**构造容器为length的空表*/
    public SeqList(int length){
        this.element=new Object[length];
        this.n=0;
    }

    /**创建默认容器的空表，构造方法重载*/
    public SeqList(){
        this(64);
    }

    /**构造顺序表，由values数组提供元素*/
    public SeqList(T[] values){
        this(values.length);
        for (int i=0; i<values.length; i++){
            this.element[i]=values[i];
        }
        this.n=values.length;
    }

    /**判断线性表是否为空，若空返回true*/
    public boolean isEmpty(){
        return this.n==0;
    }

    /**返回线性表个数（长度）*/
    public int size(){
        return this.n;
    }

    /**返回第i个元素*/
    T get(int i){
        if (i>=0 && i<=this.n){
            return (T)this.element[i];
        }
        return null;
    }

    /**设置第i个元素为x*/
    public void set(int i, T x){
        if (x==null){
            throw new NullPointerException("x=null");
        }
        if (i>=0 && i<this.n){
            this.element[i]=x;
        }else {
            throw new java.lang.IndexOutOfBoundsException(i+"");
        }
    }

    /**返回线性表所有元素的描述字符串*/
    @Override
    public String toString(){
        String string=this.getClass().getName()+"（";
        if (this.n>0) {
            string += this.element[0].toString();
            for (int i = 1; i < this.n; i++) {
                string += "，" + this.element[i].toString();
            }
        }
        return string+"）";
    }

    /**返回所有元素的描述字符串（次序从后向前），方法体省略*/
    public String toPreviousString(){
        String string=this.getClass().getName()+"（";
        if (this.n>0) {
            string += this.element[this.n - 1].toString();
            for (int i = this.n - 2; i >= 0; i--) {
                string += "，" + this.element[i].toString();
            }
        }
        return string+"）";

    }

    /**插入x作为第i个元素，x!=null，返回x序号*/
    public int insert(int i, T x){
        if (this.n==this.element.length||i>this.element.length){
            Object[] elementTemp=this.element;
            this.element=new Object[this.n*2];
            for (int j=0; j<this.n; j++){
                this.element[j]=elementTemp[j];
            }
        }
        if (i>=0 && i<=this.n){
            for (int k=this.n-1; k>=i; k++){
                this.element[k+1]=this.element[k];
            }
            this.element[i-1]=x;
        }else {
            this.element[i-1]=x;
        }
        if (x != null){
            return i-1;
        }else {
            return -1;
        }
    }

    /**在线性表最后插入x元素，返回x序号*/
    public int insert(T x){
        return this.insert(this.n,x);
    }

    /**删除第i个元素，返回被删除元素*/
    public T romove(int i){
        
    }

    /**删除线性表所有元素*/
    public void clear(){

    }

    /**查找首次出现的与key相等元素，返回元素序号i*/
    public int search(T key){

    }

    /**判断是否包括关键字为key元素*/
    public boolean contains(T key){

    }

    /**插入不重复元素*/
    public int insertDifferent(T x){

    }

    /**删除首次出现的与key相等元素，返回被删除元素*/
    public T remove(T key){

    }

    /**比较两个线性表所有元素是否对应相等*/
    @Override
    public boolean equals(Object object){

    }

    /**在this中添加list的所有元素，集合并运算*/
    public void addAll(List<T> list){

    }
}
