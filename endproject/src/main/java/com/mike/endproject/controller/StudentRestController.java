package com.mike.endproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mike.endproject.data.Student;
import com.mike.endproject.data.Course;
import com.mike.endproject.service.StudentService;

@RestController
public class StudentRestController {

    @Autowired
    StudentService sService;
    
    
    @GetMapping("students")
    public List<Student> getStudents(){
        return sService.getAllStudents();
    }

     
    @GetMapping("studentsfromfile")
    public String getStudentsFromFile()throws Exception{
        return sService.getStudentsFromFile();
    }

    
    @GetMapping("coursesfromfile")
    public String getCoursesFromFile()throws Exception{
        return sService.getCoursesFromFile();
    }

    @GetMapping("error")
    public String throwError()throws Exception{
        return "Something went wrong!";
    }


    @GetMapping("courses")
    public List<String> getCourses(){
        return sService.getAllCourses();
    }

    @GetMapping("searchById")
    public Student getById(@RequestParam long id){
        return sService.getById(id);
    }

    @GetMapping("searchByName")
    public List<Student> getByName(@RequestParam String name){
        return sService.searchByName(name);
    }

    @PostMapping("addstudent")
    public Student addStudent(@RequestParam String student)throws Exception{
        Student s = new Student(student);
        sService.addStudent(s);
        sService.saveStudentsToFile("students.txt", s);
        return s;
    }

    //Thunder Clientille oppilaan lisäys
    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student)throws Exception{
        sService.addStudent(student);
        sService.saveStudentsToFile("students.txt", student);
        return student;
    }

    @PostMapping("addcourse")
    public Course addCourse(@RequestParam String courseName, @RequestParam String teacher, @RequestParam String classRoom) throws Exception{
        Course c = new Course(courseName,teacher,classRoom);
        sService.addCourse(c);
        sService.saveCoursesToFile("courses.txt", c);
        return c;
    }

    //Thunder Clientille kurssin lisäys
    @PostMapping("addCourse")
    public Course addCourse(@RequestBody Course course) throws Exception{
        sService.addCourse(course);
        sService.saveCoursesToFile("courses.txt", course);
        return course;
    }

    @PutMapping("addtocourse")
    public String addToCourse(@RequestParam String courseName, @RequestParam String name) throws Exception{
        sService.addToCourse(courseName,name);
        return "";
    }
    //Deletet saattavat antaa erroria Thunder Clientissä, mutta itsellä ainakin toimivat
    @DeleteMapping("deletestudent")
    public String deleteStudent(@RequestParam long id){
        sService.deleteStudent(id);
        return "";
    }

    @DeleteMapping("deletefromcourse")
    public String deleteFromCourse(@RequestParam String courseName, @RequestParam long id){
        sService.deleteFromCourse(courseName, id);
        return "";
    }

   
}
