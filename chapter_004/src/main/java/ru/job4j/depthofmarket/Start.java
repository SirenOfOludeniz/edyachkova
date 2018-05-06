package ru.job4j.depthofmarket;

public class Start {
   private final UserInput userInput;

    public Start() {
        userInput = new UserInput();
    }

    public void init() {
        ActionSystem actionSystem = new ActionSystem();
        Menu menu = new Menu();
        String exit;
        do {
            String choice = "Выберите действие: 1 - Ввести заявку, 2 - показать стакан";
            menu.select(userInput.actionInt(choice));
            System.out.println();
            exit = userInput.actionString("Выйти из программы?");
        }
        while (!exit.equals("Y"));
    }

    public static void main(String[] args) {
        Start start = new Start();
        start.init();
    }

    }


