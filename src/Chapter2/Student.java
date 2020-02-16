package Chapter2;

/**例2.4  P34*/
public class Student extends Object implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", score=" + score + '}';
    }

    /**比较name是否相等*/
    @Override
    public boolean equals(Object obj) {
        return this==obj||(obj instanceof Student && this.name.equals(((Student) obj).name));
    }

    /**按成绩比较对象大小*/
    @Override
    public int compareTo(Student student) {
        return this.score-student.score;
    }
}
