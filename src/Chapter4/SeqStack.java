package Chapter4;

import Chapter2.SeqList;

/**顺序栈类，最终类，实现栈接口*/
public final class SeqStack<T> implements Stack<T> {
    /**使用顺序表存储栈元素*/
    private SeqList<T> list;

    /**构造容量为length的空栈*/
    public SeqStack(int length) {
        this.list=new SeqList<T>(length);
    }

    /**构造默认容量的空栈*/
    public SeqStack( ) {
        this(64);
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
            this.list.insert(x);
        }
    }

    /**返回栈顶元素（未出栈），若栈空返回null*/
    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.list.get(this.list.size()-1);
    }

    /**出栈，返回栈顶元素；若栈空返回null*/
    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        return this.list.remove(this.list.size()-1);
    }
}
