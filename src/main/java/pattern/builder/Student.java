package pattern.builder;

import beans.User;


/**
 * Created by adimn on 2018/8/2.
 */
public class Student {
    private String name;
    private Integer age;
    private String Gender;

    private Student(StudentBuilder sb) {
        this.name = sb.name;
        this.age = sb.age;
        Gender = sb.gender;
    }

    public static class StudentBuilder{
        private String name = "ang";
        private Integer age = 10;
        private String gender = "female";
        public  StudentBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(Integer age){
            this.age = age;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    }

    public static void main(String[] args) {
        Student st = new Student.StudentBuilder().setName("ang").setAge(10).setGender("male").build();
    }

}
