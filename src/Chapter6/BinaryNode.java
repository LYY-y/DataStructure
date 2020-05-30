package Chapter6;
//二叉链表结点类
public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left, right;

    public BinaryNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}
