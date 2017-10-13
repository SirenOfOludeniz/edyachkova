package ru.job4j;

public class Teacher {
    String sex;
    int age;
    String graduation;
    String kafedra;

    public void teach(Student student) {
        System.out.println("Приступим к занятиям, Сегодня у нас лекция о ...");
    }
    public Teacher(String sex, int age, String graduation, String kafedra) {
        this.sex = sex;
        this.graduation = graduation;
        this.age = age;
        this.kafedra = kafedra;
    }
}
class Course {
    public int hoursinweek;
    public int amounttheme;

    public int study(int hours, int thems) {
        return hours*thems;
    }
    public Course(int hoursinweek, int amounttheme) {
        this.hoursinweek = hoursinweek;
        this.amounttheme = amounttheme;
    }
}
class Student {
    int numbercourse;
    String sex;
    int age;
    public int amountofdisciplin;

    public int education(Course course, int amountofdisciplin, int hours, int week) {
        return course.study(hours,week)*amountofdisciplin;
    }
    public Student(int numbercourse, String sex, int age, int amountofcourse) {
        this.numbercourse = numbercourse;
        this.sex = sex;
        this.age = age;
        this.amountofdisciplin = amountofcourse;
    } }

