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
        if (x==null){
            throw new NullPointerException("x=null");
        }
        if (i<0){
            i=0;
        }
        if (i>this.n){
            i=this.n;
        }
        if (this.n==this.element.length){
            Object[] elementTemp=this.element;
            this.element=new Object[this.n*2];
            for (int j=0; j<i; j++){
                this.element[j]=elementTemp[j];
            }
        }
        for (int k=this.n-1; k>=i; k++){
            this.element[k+1]=this.element[k];
        }
        this.element[i]=x;
        this.n++;
        return i;
    }

    /**在线性表最后插入x元素，返回x序号*/
    public int insert(T x){
        return this.insert(this.n,x);
    }

    /**删除第i个元素，返回被删除元素*/
    public T remove(int i){
        if (i>=0 && i<this.n){
            T del=(T)element[i];
            for (int k=i; k<this.n-1; k++){
                this.element[k]=this.element[k+1];
            }
            this.element[n-1]=null;
            this.n--;
            return del;
        }else {
            return null;
        }
    }

    /**删除线性表所有元素*/
    public void clear(){
        this.n=0;
    }

    /**查找首次出现的与key相等元素，返回元素序号i*/
    public int search(T key){
        if (key==null){
            throw new NullPointerException("x=null");
        }
        for (int i=0; i<this.n; i++){
            if (this.element[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    /**判断是否包括关键字为key元素*/
    public boolean contains(T key){
        if (this.search(key)!=-1){
            return true;
        }
        return false;
        //相当于return this.search(key)!=-1;
    }

    /**插入不重复元素，查找不成功时，尾插入*/
    public int insertDifferent(T x){
        if (this.search(x)==-1){
            return insert(x);
        }else {
            return -1;
        }
        //相当于return this.search(x)==-1 ? this.insert(x) : -1;
    }

    /**删除首次出现的与key相等元素，返回被删除元素。查找不成功则返回null*/
    public T remove(T key){
        return this.remove(this.search(key));
    }

    /**比较两个线性表所有元素是否对应相等*/
    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object instanceof SeqList<?>){
            SeqList<T> list=(SeqList<T>)object;
            if (list.n==this.n){
                for (int i=0; i<this.n; i++){
                    if(!this.element[i].equals(list.element[i])){
                        return false;
                    }
                }
                return true;
            }

        }
        return false;
    }

    /**在this中添加list的所有元素，集合并运算*/
    public void addAll(List<T> list){

    }

    /**顺序表的浅拷贝。拷贝构造方法，复制对象。但数组是引用数据类型，只复制了数组引用或对象引用，没有实现对对象的复制功能
    public SeqList(SeqList<T> list){
        this.n=list.n;
        this.element=list.element;
    }
     */

    /**顺序表的深拷贝，申请数组存储空间并复制所有数组元素*/
    public SeqList(SeqList<? extends T> list){
         this.n=list.n;
         this.element=new Object[list.element.length];
         for (int i=0; i<this.n; i++){
             this.element[i]=list.element[i];
         }
    }
}
