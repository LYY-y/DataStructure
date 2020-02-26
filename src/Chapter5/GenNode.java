package Chapter5;
/**广义双链表表示的结点类*/
public class GenNode<T> {
    private T data;
    public GenList<T> child;
    public GenNode<T> next;

    public GenNode(T data, GenList<T> child, GenNode<T> next) {
        this.data = data;
        this.child = child;
        this.next = next;
    }

    public GenNode(T data) {
        this.data = data;
        this.child=null;
        this.next=null;
    }

    public GenNode() {
    }

    /**返回结点数据域的描述字符串*/
    @Override
    public String toString() {
        return this.data.toString();
    }
}
