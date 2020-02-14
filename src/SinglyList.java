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
        //return this.search(key)==null ? false : true;
        //以下方法更优
        return this.search(key)!=null;
    }

    /**插入不重复元素，查找不成功时尾插入*/
    public Node<T> insertDifferent(T x){
        //return this.contains(x) ? this.search(x) : this.insert(x);
        //以下为另一种解法
        //front是p的前驱结点
        Node<T> front=this.head, p=front.next;
        //顺序查找
        while (p!=null && !p.data.equals(x)){
            front = p;
            p = p.next;
        }
        //查找成功，元素重复，不插入，返回p结点
        if (p!=null)
        {
            System.out.println("x="+x+"，元素重复，未插入。");
            return p;
        }
        //尾插入值为x结点，返回插入结点
        return front.next = new Node<T>(x,null);
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

    /**单链表的浅拷贝
     * public SinglyList(SinglyList<T> list){
     *   this.head=list.head;
     * }
     * */

    /**单链表的深拷贝*/
    public SinglyList(SinglyList<T> list){
        this();
        Node<T> p=this.head;
        Node<T> listNode=list.head.next;
        while (listNode!=null){
            p.next=new Node<T>(listNode.data,null);
            p=p.next;
            listNode=listNode.next;
        }
    }

    /**比较两条单链表是否相等*/
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj instanceof SinglyList<?>) {
            SinglyList<T> singlyList = (SinglyList<T>) obj;
            Node<T> selfNode = this.head.next;
            Node<T> objNode = ((SinglyList<T>) obj).head.next;
            while (objNode!=null && selfNode!=null){
                if (!objNode.data.equals(selfNode.data)){
                    return false;
                }
                selfNode=selfNode.next;
                objNode=objNode.next;
            }
            return (selfNode==null && objNode==null);
        }
        return false;
    }

    /**在this单链表之后合并连接list，设置list为空，集合并*/
    public void addAll(SinglyList<T> list){
        Node<T> selfNode=this.head.next;
        while (selfNode.next!=null){
            selfNode=selfNode.next;
        }
        selfNode.next= list.head.next;
        list.head.next=null;
    }


//    public void replaceAll(T key, T x){
//        Node<T> find=this.search(x);
//        while (find!=null){
//            find.data=x;
//            find=this.search(x);
//        }
//    }
    /**P59课内实验题2-4
     * 顺序查找并将所有与key相等的元素替换为x,将算法效率改为O（n）*/
    public void replaceAll(T key, T x){
        if (key==null || x==null){
            throw new NullPointerException();
        }
        Node<T> selfNode=this.head.next;
        while (selfNode!=null){
            if (key.equals(selfNode.data)){
                selfNode.data=x;
            }
            selfNode=selfNode.next;
        }
    }

    /**P59实验题2-6*/
    /**以下方法提供单链表迭代方法*/
    /**返回单链表第0个元素结点（非头结点)*/
    public Node<T> first(){
        return this.head.next;
    }

    /**返回p的后继结点*/
    public Node<T> next(Node<T> p){
        if (p==null || this.head.next==null){
            return null;
        }
        return p.next;
    }

    /**返回p的前驱结点*/
    public Node<T> previous(Node<T> p){
        if (p==null|| p==this.head.next || this.head.next==null){
            return null;
        }
        Node<T> front=this.head;
        while (front!=null && front.next!=p){
            front=front.next;
        }
        return front;
    }

    /**返回单链表的最后一个元素结点*/
    public Node<T> last(){
        Node<T> p=this.head.next;
        while (p!=null && p.next!=null){
            p=p.next;
        }
        return p;
    }

    /**以下成员方法基于顺序查找算法*/
    /**顺序查找并删除所有与key相等元素的结点*/
    public void removeAll(T key){
        if (key==null){
            throw new NullPointerException("key==null");
        }
        Node<T> p=this.head;
        while (p!=null && p.next!=null){
            if (key.equals(p.next.data)){
                p.next=p.next.next;
            }
            p=p.next;
        }
    }

    /**顺序查找并将所有与key相等的元素替换为x，即replaceAll(T key, T x)方法**/

    /**以下成员方法对子表操作*/
    /**返回由begin-end之间的元素组成的子表*/
    public SinglyList<T> subList(int begin, int end){
        SinglyList<T> subSinglyList=new SinglyList<T>();
        Node<T> subNode=subSinglyList.head;
        Node<T> selfNode=this.head.next;
        for (int i=0; i<begin; i++){
            selfNode=selfNode.next;
        }
        for (int i=begin; i<=end; i++){
            subNode.next=new Node<T>(selfNode.data,null);
            selfNode=selfNode.next;
            subNode=subNode.next;
        }
        return subSinglyList;
    }

    /**删除begin-end之间的元素，返回被删除元素组成的表*/
    public SinglyList<T> remove(int begin, int end){
        SinglyList<T> subSinglyList=new SinglyList<T>();
        Node<T> subNode=subSinglyList.head;
        Node<T> selfNode=this.head.next;
        Node<T> preNode;
        for (int i=1; i<begin; i++){
            selfNode=selfNode.next;
        }
        preNode=selfNode;
        for (int i=begin; i<=end; i++){
            subNode.next=new Node<T>(selfNode.next.data,null);
            selfNode=selfNode.next;
            subNode=subNode.next;
        }
        preNode.next=selfNode.next;
        return subSinglyList;
    }

    /**判断this单链表是否包含list的所有元素(子集)*/
    public boolean contains(SinglyList<T> list){
        if (this.size()<list.size()){
            return false;
        }
        boolean flag=false;
        Node<T> p=list.head.next;
        while (p!=null){
            flag=this.contains(p.data);
            if (flag){
                this.remove(p.data);
            }else {
                return false;
            }
            p=p.next;
        }
        return flag;
    }

    /**在第i个结点前复制插入list所有元素，集合并*/
    public void addAll(int i, SinglyList<T> list){
        Node<T> selfNode=this.head.next;
        Node<T> rear;
        for (int k=0; selfNode.next!=null && k<i-1; k++){
            selfNode=selfNode.next;
        }
        rear=selfNode.next;
        selfNode.next= list.head.next;
        list.head.next=null;
        while (selfNode.next!=null){
            selfNode=selfNode.next;
        }
        selfNode.next=rear;
    }

    /**返回将this与list合并连接的单链表，并集*/
    public SinglyList<T> union(SinglyList<T> list){
        SinglyList<T> singlyList=new SinglyList<T>(this);
        singlyList.addAll(list);
        return singlyList;
    }

    /**删除那些也在list中的元素，差集*/
    public void substract(SinglyList<T> list){
        Node<T> listNode=list.head.next;
        while (listNode!=null){
            if (this.contains(listNode.data)){
                this.removeAll(listNode.data);
            }
            listNode=listNode.next;
        }
    }

    /**返回this与list的差集*/
    public SinglyList<T> difference(SinglyList<T> list){
        SinglyList<T> singlyList=new SinglyList<T>(this);
        singlyList.substract(list);
        return singlyList;
    }

    /**仅保留那些也包含在list中的元素*/
    public void retainAll(SinglyList<T> list){
        Node<T> selfNode=this.head.next;
        Node<T> listNode=list.head.next;
        while (selfNode!=null){
            if (!list.contains(selfNode.data)){
                this.removeAll(selfNode.data);
            }
            selfNode=selfNode.next;
        }
    }

    /**返回this与list的交集，包含两者所有共同元素*/
    public SinglyList<T> intersection(SinglyList<T> list){
        SinglyList<T> singlyList=new SinglyList<T>(this);
        singlyList.retainAll(list);
        return singlyList;
    }

    /**查找返回this中首个与pattern匹配的结点，模式匹配*/
    public Node<T> search(SinglyList<T> pattern){
        if (this.size()<pattern.size()){
            return null;
        }
        Node<T> selfNode=this.head.next;
        Node<T> patternNode=pattern.head.next;
        Node<T> markNode=selfNode;
        while (selfNode!=null && patternNode!=null){
            if (selfNode.data.equals(patternNode.data)){
                selfNode=selfNode.next;
                patternNode=patternNode.next;
                continue;
            }
            selfNode=selfNode.next;
            markNode=selfNode;
        }
        return markNode;
    }

    /**删除this中所有与pattern匹配的子表，包含模式匹配*/
    public void removeAll(SinglyList<T> list){
        
    }

    /**将this中所有与pattern匹配的子表替换为list，包含模式匹配*/
    public void raplaceAll(SinglyList<T> list){

    }
}
