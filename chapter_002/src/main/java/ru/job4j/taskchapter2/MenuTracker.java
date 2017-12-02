package ru.job4j.taskchapter2;

class EditItem implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.action("Введите id");
        String name = input.action("Введите называние заявки");
        String desc = input.action("Введите описание");
        long date = input.inputdate("Введите дату");
        String comment = input.action("Введите комментарий");
        Item item = new Item(id, name, desc, date, comment);
        item.setId(id);
        tracker.update(new Item(id, name, desc, date, comment));
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Update item.");
    }
}

class DeleteItem implements UserAction {
    public int key() {
        return 3;
    }
    public void execute(Input input, Tracker tracker) {
        tracker.delete(tracker.findById(input.action("Введите id удаляемой заявки")));
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }
}



public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int position = 0;


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] range() {
        int[] rsl = new int[position]; //здесь был [position]
        int count = 0;
        for (UserAction action : this.actions) {
            rsl[count++] = action.key();
        }
        return rsl;
    }

    /*public static void test() { //mojno zakommentit
        MenuTracker tr = new MenuTracker();
        AddItem item = tr.new AddItem();
    }*/

    public void fillActions() {
        this.actions[position++] = this.new AddItem();
        this.actions[position++] = new MenuTracker.ShowItems(); // new ShowItems();
        this.actions[position++] = new EditItem();
        this.actions[position++] = new DeleteItem();
        this.actions[position++] = this.new FindByName();
        this.actions[position++] = new MenuTracker.FindItemById();

    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public void select(int key) { // SELECT НАШЕЛСЯ!!!!!!!!!!!!
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for(UserAction action : this.actions) {
            if(action != null)
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction { //внутренний нестатический класс
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.action("Введите id");
            String name = input.action("Введите название заявки");
            String desc = input.action("Введите описание");
            long date = input.inputdate("Введите дату");
            String comment = input.action("Введите комментарий");
            tracker.add(new Item(id, name, desc, date, comment));
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    private class FindByName implements UserAction{
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            for (int i = 0; i < tracker.findByName(input.action("Enter name of items")).length ; i++) {
                System.out.println(tracker.findByName("")[i]);

            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find Items by Name");
        }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {

            for(Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s. %s. %d. %s", item.getId(), item.getName(), item.getDescription(), item.getDatecreation(), item.getKomment()));
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
    private static class FindItemById implements UserAction {
        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {

            System.out.println(tracker.findById(input.action("Enter id")));
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by Id");
        }
    }







}
