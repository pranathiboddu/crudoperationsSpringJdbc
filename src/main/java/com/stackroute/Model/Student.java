package com.stackroute.Model;

public class Student {
    //initializing student fields
    private int id,age;
    private String name,gender;
    //generating setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //initializing parameterized constructor
    public Student(int id,String name,String gender,int age)
    {
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
    }
    public Student()
    {

    }
    //method to override a string
    @Override
    public String toString()
    {
        return "id=" +id+ " name=" +name+ " gender=" +gender+ " =age=" +age;
    }

}
