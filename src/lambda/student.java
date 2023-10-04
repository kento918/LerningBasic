package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    public int studentId;
    public int grade;
    public String name;
    public int age;
    public double height;

    public Student(int studentId, int grade, String name, int age, double height){
        this.studentId = studentId;
        this.grade = grade;
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
// 最年少で最も身長の高い学生を返す、関数を作成してください。もし、複数該当する場合は若いIDを持つ学生を優先してください。
        public static Student choseStudent(Student[] studentList){
        List<Student> heightMinStu = Arrays.stream(studentList)
                                               .sorted(Comparator.comparing(Student::getHeight , Comparator.reverseOrder()))
                                               .limit(1)
                                               .collect(Collectors.toList());
        return heightMinStu.get(0);
    }

}
