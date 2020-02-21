package Chapter4;

import Chapter2.SinglyList;

/**链式栈类*/
public final class LinkedStack<T> implements Stack<T>{
    /**使用单链表储存元素*/
    private SinglyList<T> list;

    /**构造默认容量的空栈*/
    public LinkedStack( ) {
        this.list=new SinglyList<T>();
    }

    /**判断栈是否空，若空返回true*/
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**元素x入栈，空对象不能入栈*/
    @Override
    public void push(T x) {
        if (x!=null){
            this.list.insert(0,x);
        }
    }

    /**返回栈顶元素（未出栈），若栈空返回null*/
    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.list.get(0);
    }

    /**出栈，返回栈顶元素；若栈空返回null*/
    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        return this.list.remove(0);
    }
}
