package ru.job4j.map;


public class MapTest {

    public static final class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
//            result = 31 * result + id;
//            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return name != null ? name.equals(user.name) : user.name == null;
        }
    }



}
