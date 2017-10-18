package ru.job4j;

public class Education {
    public static void main(String[] args) {
        Teacher SemenSemeniych = new Teacher("man", 34, "doctor", "Phylosophy");
        Student Vovan = new Student(3, "man", 22, 4);
        Course philosophy = new Course(4, 10);
        SemenSemeniych.teach(Vovan);
        System.out.println("Обрзование Вована можно измерить коэффициентом: " + Vovan.education(philosophy,4,4,10));
    }
}
