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

    }

    /**返回线性表个数（长度）*/
    public int size(){

    }

    /**返回第i个元素*/
    T get(int i){

    }

    /**设置第i个元素为x*/
    public void set(int i, T x){

    }

    /**返回线性表所有元素的描述字符串*/
    @Override
    public String toString(){

    }

    /**插入x作为第i个元素，x!=null，返回x序号*/
    public int insert(int i, T x){

    }

    /**在线性表最后插入x元素，返回x序号*/
    public int insert(T x){

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
    public 
}
