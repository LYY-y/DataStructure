/**使用排序顺序表存储所有Java关键字，判断一个字符串是否为Java关键字*/
public class Test2_3 {
    String[] keyWordsArr={"abstract", "boolean", "break", "byte", "case", "catch", "char",
            "const", "class", "continue", "default", "do", "double", "else", "extends",
            "final", "finally", "float", "for",	"goto", "if", "implements",	"import", "instanceof",
            "int", "interface", "long",	"native", "new", "package", "private", "protected",	"public",
            "return",	"short", "static", "strictfp", "super", "switch", "this", "throw", "throws",
            "transient", "try", "void", "volatile",	"while", "synchronized"};
    SortedSeqList<String> keyWords=new SortedSeqList<String>(keyWordsArr);
    public boolean isKeyWord(String string){
        return keyWords.contains (string);
    }

    public static void main(String[] args){
        Test2_3 test=new Test2_3();
        System.out.println("native是否为关键字"+test.isKeyWord("native"));
        System.out.println("key是否为关键字"+test.isKeyWord("key"));
    }
}
