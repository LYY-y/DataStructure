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

    /**拷贝构造方法，深度拷贝，复制字符*/
    public MyString(MyString str){
        this(str.value);
    }

    /**返回串长度，即字符数组变量*/
    public int length(){
        return this.value.length;
    }

    @Override
    public java.lang.String toString(){
        return new String(this.value);
    }

    /**返回第i个字符，0<=i<length()，若i越界，则抛出字符串序号越界异常*/
    public char charAt(int i){
        if (i>=0 && i<length()){
            return this.value[i];
        }
        throw new StringIndexOutOfBoundsException();
    }

    /**返回序号从begin至end-1的子串，0<=begin<length()，0<=end<=length()，begin<end
     * 否则抛出字符串序号越界异常*/
    public MyString subString(int begin, int end){
        if (begin==0 && end==this.length()){
            return new MyString(this);
        }
        return new MyString(this.value,begin,end-begin);
    }

    /**返回序号从begin至串尾的子串*/
    public MyString subString(int begin){
        return this.subString(begin,this.value.length);
    }

    /**返回this与str串连接生成的串。若str==null，则插入"null"*/
    public MyString concat(MyString str){
        if (str==null){
            str=new MyString("null");
        }
        char[] buffer=new char[this.value.length+str.value.length];
        for (int i=0; i<this.value.length; i++){
            buffer[i]=this.value[i];
        }
        for (int j=0; j<str.value.length; j++){
            buffer[this.value.length+j]=str.value[j];
        }
        return new MyString(buffer);
    }

    /**返回当前串删除所有空白的字符串*/
    public MyString trim(){
        char[] trim=new char[this.value.length];
        int trimIndex=0;
        for (int i=0; i<this.value.length; i++){
            if (this.value[i]!=' '){
                trim[trimIndex++]=this.value[i];
            }
        }
        return new MyString(trim,0,trimIndex);
    }

    /**比较this和obj引用的串是否相等，覆盖Object类方法*/
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj instanceof MyString){
            MyString myObjStr= (MyString) obj;
            if (myObjStr.value.length==this.value.length){
                for (int i=0; i<this.value.length; i++){
                    if(this.value[i]!=myObjStr.value[i]){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**比较this与str串的大小，返回两者差值*/
    @Override
    public int compareTo(MyString str) {
        for (int i=0; i<this.value.length && i<str.value.length; i++){
            if (this.value[i]!=str.value[i]){
                return this.value[i]-str.value[i];
            }
        }
        return this.value.length-str.value.length;
    }

    /**返回当前串（目标串）中首个与模式串pattern匹配的子串序号，匹配失败时返回-1*/
    public int indexOf(MyString pattern){
        return this.indexOf(pattern,0);
    }

    /**返回当前串（目标串）从begin开始首个与模式串pattern匹配的子串序号，匹配失败时返回-1
     * 0<begin<this.length()。对begin容错，若begin<0，从0开始；若begin序号越界，查找不成功
     * 若pattern==null，抛出空对象异常*/
    public int indexOf(MyString pattern, int begin){
        if (pattern==null){
            throw new NullPointerException("pattern==null");
        }
        if (begin<this.length()){
            if (begin<0){
                begin=0;
            }
            int i=begin;
            int j=0;
            int patLen=pattern.length();
            while (i<this.length()){
                if (i+patLen>this.length()){
                    return -1;
                }
                for (j=0; j<patLen; j++){
                    if (this.value[i]!=pattern.charAt(j)){
                        i=i-j+1;
                        break;
                    }
                    i++;
                    if(j==patLen-1){
                        return i-patLen;
                    }
                }
            }
            return i-patLen;
        }else {
            return -1;
        }
    }



    /**将所有与pattern匹配的子串替换为str*/
    public MyString replaceAll(MyString pattern, MyString str){
        int i=this.indexOf(pattern);
        MyString result=new MyString(this);
        while (i!=-1){
            result=result.subString(0,i).concat(str).concat(result.subString(i+pattern.length()));
            i=result.indexOf(pattern,i+str.length());
        }
        return result;
    }

}
