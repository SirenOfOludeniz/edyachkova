package ru.job4j;

public class Education {
    public static void main(String[] args) {
        Teacher semensemeniych = new Teacher("man", 34, "doctor", "Phylosophy");
        Student vovan = new Student(3, "man", 22, 4);
        Course philosophy = new Course(4, 10);
        semensemeniych.teach(vovan);
        System.out.println("Обрзование Вована можно измерить коэффициентом: " + vovan.education(philosophy, 4, 4, 10));
    }
}
