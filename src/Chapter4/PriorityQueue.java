package Chapter4;

import Chapter2.SortedCirDoublyList;

/**优先队列类（升序或降序）*/
public final class PriorityQueue<T extends Comparable<? super T>> implements Queue<T> {
    private SortedCirDoublyList<T> list;
    private boolean asc;

    public PriorityQueue(boolean asc){
        this.list=new SortedCirDoublyList<T>();
        this.asc=asc;
    }

    public PriorityQueue() {
        this(true);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean add(T x) {
        return this.list.insert(x)!=null;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        }
        if (asc){
            return this.list.get(0);
        }else {
            return this.list.head.prev.data;
        }
    }

    @Override
    public T poll() {
        if (isEmpty()){
            return null;
        }
        if (asc){
            return this.list.remove(0);
        }else {
            return this.list.removeLast();
        }
    }

    @Override
    public String toString(){
        String string=this.getClass().getName()+" ";
        if (asc){
            string+=this.list.toString();
        }else {
            string+=this.list.toPreviousString();
        }
        return string;
    }
}
