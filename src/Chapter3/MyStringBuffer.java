package Chapter3;
/**变量字符串类，最终类，实现序列化接口*/
public class MyStringBuffer implements java.io.Serializable{
    /**字符数组，私有成员变量*/
    private char[] value;
    /**串长度*/
    private int n;

    /**构造容量为capacity方法*/
    public MyStringBuffer(int capacity) {
        this.value=new char[capacity];
        this.n=0;
    }

    /**以默认容量构造空串*/
    public MyStringBuffer(){
        this(16);
    }

    /**以字符串常量构造串*/
    public MyStringBuffer(String str){
        this(str.length()+16);
        for (int i=0; i<str.length(); i++){
            this.value[i]=str.charAt(i);
        }
        this.n=str.length();
    }

    /**返回字符串长度*/
    public int length(){
        return this.n;
    }

    /**返回字符数组容量*/
    public int capacity(){
        return this.value.length;
    }

    /**以value数组从0至n字符构造String串*/
    @Override
    public synchronized String toString(){
        return new String(this.value,0,this.n);
    }

    /**返回第i个字符，0<=i<=length()*/
    public synchronized char charAt(int i){
        if (i>=0 && i<this.n){
            int j=0;
            while (j<i){
                j++;
            }
            return this.value[j];
        }
        throw new StringIndexOutOfBoundsException();
    }

    /**设置第i个字符为ch，0<=i<=length()*/
    public void setCharAt(int i, char ch){
        if (i>=0 && i<this.n){
            int j=0;
            while (j<i){
                j++;
            }
            this.value[j]=ch;
        }else {
            throw new StringIndexOutOfBoundsException();
        }
    }

    /**在第i个字符处插入str串，0<=i<=length()。若i序号越界，抛出异常；若srt==null，插入“null”*/
    public synchronized MyStringBuffer insert(int i, String str){
        if (i>=0 && i<=this.n && this.n>0 || this.n==0 && i==0){
            if (str==null){
                str="null";
            }
            if ((this.n+str.length())<this.value.length){
                for (int k=this.n-1+str.length(); k>=i+str.length(); k--){
                    this.value[k]=this.value[k-str.length()];
                }
                for (int j=i; j<=i+str.length()-1; j++){
                    this.value[j]=str.charAt(j-i);
                }
            }else {
                char[] temp=this.value;
                this.value=new char[(this.value.length+str.length())*2];
                for (int k=0; k<i; k++){
                    this.value[k]=temp[k];
                }
                for (int k=i; k<i+str.length(); k++){
                    this.value[k]=str.charAt(k-i);
                }
                for (int k=i+str.length(); k<str.length()+this.n; k++){
                    this.value[k]=temp[k-str.length()];
                }
            }
            this.n+=str.length();
            return this;
        }else {
            throw new StringIndexOutOfBoundsException("i="+i);
        }
    }

    public synchronized MyStringBuffer insert(int i,MyStringBuffer sbuf){
        return this.insert(i,sbuf.toString());
    }

    /**在i处插入变量值转换成的串*/
    public synchronized MyStringBuffer insert(int i, boolean b){
        if (b){
            return this.insert(i,"true");
        }else {
            return this.insert(i,"false");
        }
    }

    /**添加str串*/
    public synchronized MyStringBuffer append(String str){
        return this.insert(this.n,str);
    }

    /**删除从begin到end-1的子串，0<=begin<length，end>=0，begin<=end；
     * 若end>=length()，删除到串尾；若begin越界，或begin>end抛出字符串序号越界异常*/
    public synchronized MyStringBuffer delete(int begin, int end){
        if (begin>=0 && begin<this.n && end>=0 && begin<=end){
            if (end>this.n){
                end=this.n;
            }
            for (int i=begin; i<end; i++){
                this.value[i]=this.value[end+i-begin];
            }
            this.n=this.n-(end-begin);
            return this;
        }
        throw new StringIndexOutOfBoundsException("begin："+begin+"，end"+end+"，end-begin="+(end-begin));
    }

    /**将从begin到end-1子串替换为s串*/
    public synchronized MyStringBuffer replace(int begin, int end, String s){
        if (begin>=0 && begin<this.n && end>=0 && begin<=end){
            if (end>this.n){
                end=this.n;
            }
            char[] temp=this.value;
            if (this.n-(end-begin)+s.length()>this.value.length){
                this.value=new char[(this.n-(end-begin)+s.length())*2];
                for (int i=0; i<begin; i++){
                    this.value[i]=temp[i];
                }
            }
            if (s.length()>=(end-begin)){
                for (int j=0; j<s.length()-(end-begin); j++){
                    this.value[j+end+(s.length()-(end-begin))]=temp[this.n-j-1];
                }
            }else {
                for (int j=0; j<(end-begin)-s.length(); j++){
                    this.value[j+end-((end-begin)-s.length())]=temp[this.n-j-1];
                }
            }
            for (int j=0; j<s.length(); j++){
                this.value[begin+j]=s.charAt(j);
            }
            this.n=this.n+s.length()-(end-begin);
            return this;
        }
        throw new StringIndexOutOfBoundsException("begin："+begin+"，end"+end+"，end-begin="+(end-begin));
    }


}
