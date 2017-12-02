package ru.job4j.taskchapter2;

public class ValidateInput extends ConsoleInput {
    public int action(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.action(question, range); // super вызов родительского класса
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        } while (invalid);
        return value;
    }
}
