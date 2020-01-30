/**Josephus环问题（P24）*/
public class Josephus {
    public Josephus(int number, int start, int distance) {
        SeqList<String> list=new SeqList<String>(number);
        for (int k=0; k<number; k++){
           list.insert((char)(97+k)+"");
        }

        for (int i=start; list.size()>1;){
            int tempDistance=distance;
            while (tempDistance>list.size()){
               tempDistance=tempDistance-list.size();
            }
            i=i+tempDistance-1;
            if (i>list.size()-1) {
                i=i-list.size();
            }
            System.out.println("被删除元素为：" + list.remove(i));
        }
        System.out.print("被释放的为："+list.get(0));
    }
    public static void main(String[] args){
        Josephus jtest=new Josephus(5,0,2);

    }
}
