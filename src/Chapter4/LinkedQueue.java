package Chapter4;

import Chapter2.Node;

public class LinkedQueue<T> implements Queue<T>{
    private Node<T> front;
    private Node<T> rear;

    public LinkedQueue() {
        this.front=this.rear=null;
    }

    @Override
    public boolean isEmpty() {
        return this.front==null && this.rear==null;
    }

    @Override
    public boolean add(T x) {
        if (x==null){
            return false;
        }
        Node<T> q=new Node<T>(x,null);
        if (this.front==null){
            this.front=q;
        }else {
            this.rear.next=q;
        }
        this.rear=q;
        return true;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        }
        return this.rear.data;
    }

    @Override
    public T poll() {
        if (isEmpty()){
            return null;
        }
        T frontObj=this.front.data;
        this.front=this.front.next;
        if (this.front==null){
            this.rear=null;
        }
        return frontObj;
    }
}
