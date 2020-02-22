package Chapter4;

public final class SeqQueue<T> implements Queue<T>{
    /**存储队列数据元素的数组*/
    private Object[] element;
    /**front、rear分别为队列头尾下标*/
    private int front;
    private int rear;

    public SeqQueue(int length) {
        if (length<64){
            length=64;
        }
        this.element=new Object[length];
        this.front=0;
        this.rear=0;
    }

    public SeqQueue(){
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.front==this.rear;
    }

    @Override
    public boolean add(T x) {
        if (x == null){
            return false;
        }
        if (this.front==(this.rear+1)%this.element.length){
            Object[] temp=this.element;
            this.element=new Object[this.element.length*2];
            int j=0;
            for (int i=this.front; i!=this.rear; i=(i+1)%temp.length){
                this.element[j++]=temp[i];
            }
            this.front=0;
            this.rear=j;
        }
        this.element[this.rear]=x;
        this.rear=(this.rear+1)%this.element.length;
        return true;
    }

    /**返回队头元素，没有删除*/
    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        }
        return (T)this.element[this.front];
    }

    /**出队，返回队头元素*/
    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T frontObj=(T)this.element[this.front];
        this.front=(this.front+1)%this.element.length;
        return frontObj;
    }
}
