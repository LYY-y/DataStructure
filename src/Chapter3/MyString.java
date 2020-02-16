package Chapter3;

public class MyString implements Comparable<MyString>,java.io.Serializable{
    /**字符数组，私有最终变量，只能赋值一次*/
    private final char[] value;

    /**构造空串""，串长度为0*/
    public MyString() {
        this.value=new char[0];
    }

    /**由字符串常量构造串*/
    public MyString(java.lang.String str) {
        this.value=new char[str.length()];
        for (int i=0; i<str.length(); i++){
            this.value[i]=str.charAt(i);
        }
    }

    /**由value数组从i开始的n个字符构造串，i>=0，n>=0，i+n<=value.length
     * 若i与n指定序号越界，则抛出字符串序号越界异常*/
    public MyString(char[] value,int i,int n) {
        if (i+n>value.length || i<0 || n<0) {
            throw new StringIndexOutOfBoundsException();
        }
        this.value=new char[n];
        for(int j=0, k=i; j<n; k++,j++){
            this.value[j]=value[k];
        }
    }

    /**以字符数组构造串*/
    public MyString(char[] value){
        this(value,0,value.length);
    }

    @Override
    public int compareTo(MyString o) {
        return 0;
    }
}
