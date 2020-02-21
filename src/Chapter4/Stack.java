package Chapter4;
/**栈接口，描述栈抽象数据类型*/
public interface Stack<T> {
    /**判断栈是否空*/
    public abstract boolean isEmpty();
    /**元素x入栈*/
    public abstract void push(T x);
    /**返回栈顶元素，未出栈*/
    public abstract T peek();
    /**出栈，返回栈顶元素*/
    public abstract T pop();
}
