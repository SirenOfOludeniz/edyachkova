package ru.job4j.array;

public class ArrayExample {
    public static void main(String[] args) {
        User[] users = new User[5];
        users[0] = new User("Petr");
        users[1] = new User("Nick");
        users[2] = new User("Make");
        users[3] = new User("Miron");
        users[4 ] = new User("Nan");

        User user = ArrayExample.findByName(users, "Nick");
        System.out.println(user.name);

       /*String[] values = new String[10];
        values[0] = "zero";
        values[1] = "first";
        values[2] = "third";
        System.out.println(values);
        System.out.println(values[0] +  " " + values[1] + " " + values[2]);
        String[] names = new String[] {"Katya", "Petr", "Vanya"};
        for (int i = 0; i != names.length ; i++) {
            System.out.println(names[i]); }
           for(String name : names) {
                System.out.println(name);
            }}*/
    }
    public static User findByName(User[] users, String name) {
        User result = null; //создаем пустого пользователя
        for(User user : users) {
            if(name.equals(user.name)) { // user.name == у ссылочной переменной объекта User получаем поле name этого объекта
                result = user; //инициализируем переменную "User user <--- вот её инициализируем
                break; // останавливаемся , так как нашли пользователя
            }
        }
        return result; //возвращаем наш массив
    }
}
