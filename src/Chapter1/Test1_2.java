package Chapter1;

import java.util.HashMap;

//生成以下产生随机数的方法
public class Test1_2 {
    //以下注释为题目要求
    //返回n个互异的随机数，范围是0-size-1
    public static Integer[] randomDifferent(int n, int size){
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0; map.size()<n; i++){
            map.put((int)(Math.random()*size),i);
        }
        Integer[] random=map.keySet().toArray(new Integer[n]);
        return random;
    }
    //返回n个排序的随机数
    public static Integer[] randomSorted(int n, int size){
        Integer[] random=new Integer[n];
        for (int i=0; i<n; i++){
            random[i]=(int)(Math.random()*size);
        }
        new Test1_2().sorted(random);
        return random;
    }
    //返回n个互异的排序的随机数
    public static Integer[] randomDifferentSorted(int n, int size){
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0; map.size()<n; i++){
            map.put((int)(Math.random()*size),i);
        }
        Integer[] random=map.keySet().toArray(new Integer[n]);
        new Test1_2().sorted(random);
        return random;
    }


    public Integer[] sorted(Integer[] integers){
        int tempMinIndex;
        for (int i=0; i<integers.length; i++){
            tempMinIndex=i;
            for (int j=i; j<integers.length; j++){
                if (integers[tempMinIndex]>integers[j]){
                    tempMinIndex=j;
                }
            }
            int temp=integers[i];
            integers[i]=integers[tempMinIndex];
            integers[tempMinIndex]=temp;
        }
        return integers;
    }

    public static void printRandom(Integer[] integers){
        for (Integer integer:integers){
            System.out.print(integer+"  ");
        }
    }

    public static void main(String[] args){
        System.out.print("返回10个0-19互异的随机数：");
        printRandom(randomDifferent(10,20));
        System.out.print("\n返回10个0-19的排序随机数：");
        printRandom(randomSorted(10,20));
        System.out.print("\n返回10个0-19互异的排序的随机数：");
        printRandom(randomDifferentSorted(10,20));
    }


}
