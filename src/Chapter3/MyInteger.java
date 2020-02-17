package Chapter3;
/**整数类*/
public final class MyInteger implements Comparable<MyInteger>{
    /**最小值常量*/
    public static final int MIN_VALUE=0x80000000;
    /**最大值常量*/
    public static final int MAX_VALUE=0x7ffffff;
    /**私有最终变量，存储整数，赋值一次*/
    private final int value;

    /**由int整数value构造整数对象*/
    public MyInteger(int value){
        this.value=value;
    }

    /**由十进制整数字符串s构造整数对象。构造方法只支持十进制，s包含正负号*/
    public MyInteger(String s) throws NumberFormatException{
        this.value=Integer.parseInt(s,10);
    }

    /**返回整数型*/
    public int intValue(){
        return this.value;
    }

    /**返回当前整数的十进制字符串*/
    @Override
    public String toString() {
        return this.value+"";
    }

    /**比较对象是否相等*/
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        return obj instanceof MyInteger && this.value==((MyInteger) obj).intValue();
    }

    @Override
    /**比较对象值大小*/
    public int compareTo(MyInteger iobj) {
        if (this.value<iobj.value){
            return -1;
        }else if (this.value>iobj.value){
            return 1;
        }
        return 0;
    }

    /**将串s按十进制转换为整数*/
    public static int parseInt(String s) throws NumberFormatException{
        return MyInteger.parseInt(s,10);
    }

    /**将串s按radix进制转换为整数，s指定整数的radix进制原码字符串，包含正负号，
     * 2<=radix<=16，默认十进制。若不能将s转换成整数，则抛出数值格式异常*/
    public static int parseInt(String s,int radix) throws NumberFormatException{
        if (s==null){
            throw new NumberFormatException("null");
        }
        if (radix<2 || radix>16){
            throw new NumberFormatException("radix="+radix+"进制超过2-16的范围！");
        }
        int sign=1;
        if (s.charAt(0)=='-'){
            sign=-1;
            s=s.substring(1);
        }
        int value=0;
        int i=0;
        int length=s.length();
        char ch;
        while (i<s.length()){
            ch=s.charAt(i++);
            if (ch==0){
                length--;
                continue;
            }
            if ((int)ch>=49 && (int)ch<=57){
                value+=((int)ch-48)*Math.pow(radix,length-1);
            }else if ((int)ch>=65 && (int)ch<=70){
                value+=((int)ch-55)*Math.pow(radix,length-1);
            }else if ((int)ch>=97 && (int)ch<=102){
                value+=((int)ch-87)*Math.pow(radix,length-1);
            }else {
                throw new NumberFormatException(radix+"进制不能识别"+ch);
            }
            length--;
        }
        if (sign==-1){
            value=0-value;
        }
        return value;
    }
}
