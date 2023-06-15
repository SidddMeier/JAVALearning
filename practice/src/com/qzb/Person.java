package com.qzb;

public class Person {
    public String name;
    public  int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void run(){
        System.out.println("I AM RUNNING");
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

