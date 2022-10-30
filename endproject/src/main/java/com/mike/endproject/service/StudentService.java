package com.mike.endproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.mike.endproject.data.Student;
import com.mike.endproject.data.Course;

@Service
public class StudentService extends FileService{

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void addToCourse(String courseName, String name){
        for (Course course : courses) {
            if(course.getCourseName().equals(courseName)){
                for (Student student : students) {
                    if(student.getName().equals(name)){
                        course.setStudents(student);;
                    }
                }
            }
        }
    }

    public String getStudentsFromFile() throws Exception{
        String students = readStudentsFromFile("students.txt");
        return students;
    }

    public String getCoursesFromFile() throws Exception{
        String courses = readCoursesFromFile("courses.txt");
        return courses;
    }

    public List<String> getAllCourses(){
        List<String> found = new ArrayList<>();

        for (Course course : courses) {
            found.add("Kurssi: " + course.getCourseName() + ", Luokka: " + course.getClassRoom() + ", Opettaja: " + course.getTeacher() + ", Oppilaat: " + course.getStringStudents());
        }
        return found;
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getById(long id){
        for (Student student : students) {
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public List<Student> searchByName(String name){
        List<Student> found = new ArrayList<>();

        for (Student student : students) {
            if(student.getName().equals(name)){
                found.add(student);
            }
        }
        return found;
    }

    public void deleteStudent(long id){
        for (Student student : students) {
            if(student.getId() == id){
                students.remove(student);
            }
        }
    }

    public void deleteFromCourse(String courseName, long id){
        List<Student> found = new ArrayList<>();

        for (Course course : courses) {
            if(course.getCourseName().equals(courseName)){
                found = course.getStudents();
                for (Student student : found) {
                    if(student.getId() == id){
                        course.delStudents(student);
                    }
                }
            }
        }
    }
    
}

