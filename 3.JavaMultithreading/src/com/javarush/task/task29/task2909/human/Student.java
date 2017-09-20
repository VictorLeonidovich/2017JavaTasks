package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;
    public int getCourse() {
        return course;
    }

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }



    public void live() {
        learn();
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void learn() {
    }



    public void setCourse(int course){
        this.course = course;
    }
    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }


    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade() + delta);
    }


    public void setBeginningOfSession(Date beginningDate) {
        beginningOfSession = beginningDate;
    }

    public void setEndOfSession(Date endDate) {
        endOfSession = endDate;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}