package com.mike.endproject.data;

public class Student {
    private String name;
    private long id;
    private static long idCounter = 0;

    public Student(){
        this("");
    }

    public Student(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }
    
    public String getInfo() {
        return "Oppilas: " + this.name + ", ID: " + this.id;
    }


    
}