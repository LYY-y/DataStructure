/**多项式类*/
public class Polynomial {
    /**多项式排序单链表*/
    private PolySinglyList<TermX> list;

    /**构造方法*/
    public Polynomial() {
        this.list=new PolySinglyList<TermX>();
    }

    /**构造方法，由项数组指定多项式各项值*/
    public Polynomial(TermX terms[]){
        this.list=new PolySinglyList<TermX>(terms);
    }

    /**构造方法，参数指定多项式表达式字符串*/
    public Polynomial(String polystr){
        this();
        Node<TermX> selfNode=this.list.head;
        int length=polystr.length();
        int fromIndex=0;
        int toIndex=0;
        while (true){
            int positiveSignIndex=polystr.indexOf("-",fromIndex+1);
            int negativeSignIndex=polystr.indexOf("+",fromIndex+1);
            if (positiveSignIndex==-1 && negativeSignIndex==-1){
                selfNode.next=new Node<TermX>(new TermX(polystr.substring(fromIndex)),null);
                break;
            }
            if (positiveSignIndex==-1){
                positiveSignIndex=length;
            }
            if (negativeSignIndex==-1){
                negativeSignIndex=length;
            }
            toIndex = (positiveSignIndex < negativeSignIndex) ? positiveSignIndex : negativeSignIndex;
            selfNode.next=new Node<TermX>(new TermX(polystr.substring(fromIndex,toIndex)),null);
            fromIndex=toIndex;
            selfNode=selfNode.next;
        }
    }

    /**返回多项式的描述字符串*/
    @Override
    public String toString(){
        String string="";
        Node<TermX> selfNode=this.list.head.next;
        while (selfNode!=null){
            string+=selfNode.data.toString();
            selfNode=selfNode.next;
        }
        return string;
    }

    /**深拷贝，复制所有结点和对象*/
    public Polynomial(Polynomial poly){
        this();
        Node<TermX> selfNode=this.list.head;
        Node<TermX> listNode=poly.list.head.next;
        while (listNode!=null){
            selfNode.next=new Node<TermX>(listNode.data,null);
            selfNode=selfNode.next;
            listNode=listNode.next;
        }

    }

    /**多项式相加，this+=poly*/
    public void addAll(Polynomial poly){
        this.list.addAll(poly.list);
    }

    /**加法，返回this+poly的多项式*/
    public Polynomial union(Polynomial poly){
        Polynomial result=new Polynomial(this);
        result.addAll(poly);
        return result;
    }

    /**比较两个多项式是否相等*/
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj instanceof Polynomial){
            return this.list.equals(((Polynomial) obj).list);
        }
        return false;
    }
}
