package Chapter4;

import Chapter2.SeqList;
import Chapter2.SortedSeqList;

public class PrimeRing {
    /**求1-max的素数环*/
    public PrimeRing(int max){
        SortedSeqList<Integer> primeSet=createPrime(max*2);
        SeqList<Integer> ring=new SeqList<Integer>(max);
        ring.insert(1);
        Queue<Integer> queue=new SeqQueue<Integer>(max);
        for (int i=2; i<=max; i++){
            queue.add(i);
        }
        int i=0;
        Integer key=0;
        while (!queue.isEmpty()){
            key=queue.peek();
            if (primeSet.contains(ring.get(i)+key)){
                queue.poll();
                ring.insert(key);
                i++;
            }else {
                queue.add(key);
                queue.poll();
            }
        }
        System.out.println("1-"+max+"的素数环为："+ring.toString());
    }

    /**返回包含2-max中所有素数的顺序排序表，也可返回循环双链表*/
    public static SortedSeqList<Integer> createPrime(int max){
        if (max<=0){
            return null;
        }
        SortedSeqList<Integer> primeSet=new SortedSeqList<Integer>(max+1);
        boolean[] isPrimesSet=new boolean[max+1];
        int count=0;
        //true表示合数，false表示素数
        isPrimesSet[1]=true;
        for (int i=2; i<=max; ++i){
            if (!isPrimesSet[i]){
                primeSet.insert(i);
                count++;
            }
            for (int j=1; j<=count && i*primeSet.get(j-1)<=max; ++j){
                isPrimesSet[i*primeSet.get(j-1)]=true;
                if (i%primeSet.get(j-1)==0){
                    break;
                }
            }
        }
        return primeSet;
    }
}
