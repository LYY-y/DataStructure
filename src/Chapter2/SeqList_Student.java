package Chapter2;

public class SeqList_Student {
    /**分类统计线性表list的元素信息，分段信息存于grade数组，返回保存统计结果的数组*/
    public static int[] gradeCount(SeqList<Student> list,int grade[]){
        int[] result=new int[grade.length];
        for (int i=0; i<list.size(); i++){
            Student student=list.get(i);
            for (int j=0; j<grade.length-1; j++){
                if (student.score>=grade[j] && student.score<grade[j+1]){
                    result[j]++;
                    break;
                }
                if (student.score==grade[j+1]){
                    result[j+1]++;
                    break;
                }
            }
        }
        return result;
    }


    /**输出线性表list元素及分类统计结果*/
    public static void printCount(SeqList<Student> list, int grade[], int result[]){
        System.out.print("学生集合："+list.toString()+"共"+list.size()+"人，成绩统计：\n");
        for (int k=0; k<=result.length-1; k++){
            if (k==result.length-1){
                System.out.println(grade[k]+"分："+result[k]+"人");
                break;
            }
            System.out.println(grade[k]+"分—"+grade[k+1]+"分："+result[k]+"人");
        }
    }

    public static void searchByName(SeqList<Student> list,Student studentKey){
        System.out.print(studentKey.name+"的成绩为："+list.get(list.search(studentKey)).score);
    }

    public static void searchByScore(SeqList<Student> list,Student studentKey){
        System.out.print("成绩为"+studentKey.score+"的学生姓名为："+list.get(list.search(studentKey)).name);
    }
}
