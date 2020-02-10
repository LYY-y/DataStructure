/**可相加接口*/
public interface Addible<T> {
    /**+=加法，约定两元素相加规则*/
    public void add(T t);
    /**约定删除元素条件*/
    public boolean removeable();
}
