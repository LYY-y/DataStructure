package Chapter3;

public class PatternMatching {
    /**Brute-Force算法写在MyString.java中*/


    /**KMP算法实现*
     * 返回目标串target中首个与模式串pattern匹配的子串序号，匹配失败时返回-1
     */
    public static int indexOf(String target, String pattern){
        return indexOf(target,pattern,0);
    }

    /**返回目标串target从begin开始首个与模式串pattern匹配的子串序号，匹配失败时返回-1
     * 0<begin<target.length()。对begin容错，若begin<0，从0开始；若begin序号越界，查找不成功
     * 若pattern、target为null，抛出空对象异常*/
    public static int indexOf(String target, String pattern, int begin){
        if (pattern==null || target==null){
            throw new NullPointerException();
        }
        if (begin<target.length()){
            if (begin<0){
                begin=0;
            }
            int i=begin;
            int j=0;
            int[] next=getNext(pattern);
            while (i<target.length() && j<pattern.length()){
                if (j==-1 || target.charAt(i)==pattern.charAt(j)){
                    i++;
                    j++;
                }else {
                    j = next[j];
                    if (target.length()-i<pattern.length()-j){
                        break;
                    }
                }
            }
            if(j==pattern.length()){
                return i-j;
            }
            return -1;
        }else {
            return -1;
        }
    }


    /**改进后的next数组算法*/
    public static int[] getNext(String pattern){
        int patternLen=pattern.length();
        int[] next=new int[patternLen];
        next[0]=-1;
        int i=0;
        int k=-1;
        while (i<patternLen-1){
            if (k==-1 || pattern.charAt(i)==pattern.charAt(k)){
                i++;
                k++;
                if (pattern.charAt(i)!=pattern.charAt(k)) {
                    next[i] = k;
                }else {
                    next[i]=next[k];
                }
            }else {
                k=next[k];
            }
        }
        return next;
    }
}
