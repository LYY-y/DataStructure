package Chapter5;
/**十字链表表示的矩阵类*/
public class CrossLinkedMatrix {
    private int rows;
    private int columns;
    /**行指针数组*/
    private CrossNode[] rowHeads;
    /**列指针数组*/
    private CrossNode[] columnHeads;
}
