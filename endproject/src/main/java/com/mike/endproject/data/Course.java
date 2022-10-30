package com.mike.endproject.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String teacher;
    private String classRoom;
    private List<Student> students = new ArrayList<>();
   

    public Course(){
        this("","","");
    }

    public Course(String courseName, String teacher, String classRoom) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.classRoom = classRoom;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassRoom() {
        return this.classRoom;
    }
    public List<Student> getStudents(){
        return this.students;
    }

    public List<String> getStringStudents(){
        List<String> found = new ArrayList<>();

        for (Student student : students) {
            found.add(student.getName());
           
        }
       return found;
    }

    public void setStudents(Student student){
        this.students.add(student);
    }

    public void delStudents(Student student){
        this.students.remove(student);
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getInfo(){
        return "Kurssi: " + this.courseName + ", Opettaja: " + this.teacher + ", Luokka: " + this.classRoom + ", Oppilaat: " + this.getStringStudents();

    }

}