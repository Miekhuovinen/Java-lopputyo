package com.mike.endproject.service;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.mike.endproject.data.Student;
import com.mike.endproject.data.Course;

@Service
public class FileService {

    public void saveCoursesToFile(String filePath, Course course) throws Exception {
        FileWriter fw = new FileWriter(new File(filePath), true);

        try {
            fw.write(course.getInfo() + "\n");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        fw.close();
    }

    public void saveStudentsToFile(String filepath, Student student) throws Exception {
        FileWriter fw = new FileWriter(new File(filepath), true);

        try {
            fw.write(student.getInfo() + "\n");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        fw.close();
    }

    public String readStudentsFromFile(String filepath) throws Exception {
        Scanner fs = new Scanner(new File(filepath));
        String student = "";
        try{
            while(fs.hasNext()){
                student += fs.nextLine();
             }
        } catch (Exception e) {
            System.out.println("Tiedosto on tyhjä tai sitä ei löydy!");
        }
       
        fs.close();
        return student;
    }

    public String readCoursesFromFile(String filepath) throws Exception {
        Scanner fs = new Scanner(new File(filepath));
        String courses = "";
        try{
            while(fs.hasNext()){
                courses += fs.nextLine();
             }
        } catch (Exception e){
            System.out.println("Tiedosto on tyhjä tai sitä ei löydy!");
        }
       
        fs.close();
        return courses;
    }


}
