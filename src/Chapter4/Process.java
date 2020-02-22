package Chapter4;
/**进程类*/
public class Process implements Comparable<Process> {
    private String name;
    private int priority;

    /**构造函数，参数name、priority分别指定进程名和优先级，
     * 优先级范围为1-10，1最低，10最高，默认5，超出时抛出无效参数异常
     */
    public Process(String name, int priority) {
        this.name = name;
        if (priority>=1 && priority<=10) {
            this.priority = priority;
        }else {
            throw new IllegalArgumentException("priority="+priority);
        }
    }

    public Process(String name){
        this(name,5);
    }

    @Override
    public String toString(){
        return "("+this.name+"，"+this.priority+")";
    }

    @Override
    public int compareTo(Process p) {
        return this.priority-p.priority;
    }
}
