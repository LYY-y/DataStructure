package Chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessTest {
    @Test
    public void testProcess(){
        Process[] process={new Process("A",4),new Process("B",3),new Process("C"),
                            new Process("D",4),new Process("E",10), new Process("F",1)};
        PriorityQueue<Process> queue=new PriorityQueue<Process>(false);
        System.out.print("入队进程：");
        for (int i=0; i<process.length; i++){
            queue.add(process[i]);
            System.out.print(process[i]+" ");
        }
        System.out.print("\n出队进程：");
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
}