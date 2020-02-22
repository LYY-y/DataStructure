package Chapter4;
/**队列接口*/
public interface Queue<T> {
    /**判断队列是否空*/
    public abstract boolean isEmpty();
    /**元素x入队，若添加成功，则返回true；否则返回false*/
    public abstract boolean add(T x);
    /**返回队头元素，没有删除。若队列空，则返回null*/
    public abstract T peek();
    /**出队，返回队头元素。若队列空，则返回null*/
    public abstract T poll();
}
