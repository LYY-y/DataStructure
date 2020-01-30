/**Josephus环问题（P24）*/
public class Josephus {
    public Josephus(int number, int start, int distance) {
        SeqList<String> list=new SeqList<String>(number);
        for (int k=0; k<number; k++){
           list.insert((char)(97+k)+"");
        }

        for (int i=start; list.n>1;){
            int tempDistance=distance;
            while (tempDistance>list.n){
               tempDistance=tempDistance-list.n;
            }
            i=i+tempDistance-1;
            if (i>list.n-1) {
                i=i-list.n;
            }
            System.out.println("被删除元素为：" + list.romove(i));
        }
        System.out.print("被释放的为："+list.get(0).toString());
    }
    public static void main(String[] args){
        Josephus jtest=new Josephus(5,0,2);

    }
}
