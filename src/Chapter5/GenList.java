package Chapter5;

import Chapter2.Node;

/**双链表表示的广义表，没有表名*/
public class GenList<T> {
    public GenNode<T> head;

    public GenList() {
        this.head=new GenNode<T>();
    }

    /**返回广义表所有元素的描述字符串*/
    @Override
    public String toString() {
        return this.toString("");
    }

    /**返回广义表所有元素值对应的字符串，形式为"(，)",广义表遍历算法，递归方法*/
    public String toString(String string){
        string+="(";
        GenNode<T> p=this.head.next;
        while (p!=null){
            if (p.child==null){
                string+=p.toString()+", ";
            }else {
                string+=p.child.toString();
            }
            if (p==null){
                string+=")";
            }
            p=p.next;
        }
        return string;
    }

    /**返回广义表深度，递归方法*/
    public int depth(){
        int dep=0;
        GenNode<T> p=this.head.next;
        while (p!=null) {
            if (p.child != null) {
                int tempDep=p.child.depth();
                if (tempDep>dep){
                    dep=tempDep;
                }
            }
            p=p.next;
        }
        return dep;
    }

    /**构造广义表，由atoms数组提供原子初值*/
    public GenList(T[] atoms){
        GenNode<T> p=this.head;
        for (int i=0; i<atoms.length; i++){
            p.next=new GenNode<T>(atoms[i],null,null);
            p=p.next;
        }
    }

    /**判断广义表是否为空*/
    public boolean isEmpty(){
        return this.head.next==null;
    }

    /**返回广义表长度*/
    public int size(){
        int count=0;
        GenNode<T> p=this.head.next;
        while (p!=null){
            count++;
            p=p.next;
        }
        return count;
    }

    /**插入原子x作为第i个元素；对i容错*/
    public GenNode<T> insert(int i, T x){
        if (x == null){
            throw new NullPointerException("x == null");
        }
        GenNode<T> front = head;
        for (int j = 0; front.next != null && j < i; j++){
            front = front.next;
        }
        front.next = new GenNode<T>(x, null, front.next);
        return front.next;
    }

//    /**在广义表最后添加原子x结点*/
//    public GenNode<T> insert(T x){
//
//    }
//
//    /**插入子表glist作为第i个元素；对i容错*/
//    public GenNode<T> insert(int i, GenList<T>glist){
//
//    }
//
//    /**在广义表最后添加子表glist*/
//    public GenNode<T> insert(GenList<T> glist){
//
//    }
//
//    /**删除第i个元素*/
//    public void remove(int i){
//
//    }
}
