package Chapter1;

//1-1声明复数类，成员变量包括实部和虚部，成员方法包括实现由字符串构造复数、复数加法、减法，字符串描述、比较相等等操作。
//使用了自定义的Complex类
public class Test1_1 {
    public static void main(String[] args){
        Complex complex1=new Complex("-15.102+0.9i");
        Complex complex2=new Complex("-15.102+0.09i");
        System.out.println(Complex.equals(complex1,complex2));
    }
}
