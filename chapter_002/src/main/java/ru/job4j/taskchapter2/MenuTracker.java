package ru.job4j.taskchapter2;

class EditItem extends BaseAction {

    public EditItem(String name, int key) {
        super(name, key);
    }
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.action("Введите id");
        String name = input.action("Введите называние заявки");
        String desc = input.action("Введите описание");
        String date = input.action("Введите дату");
        String comment = input.action("Введите комментарий");
        Item item = new Item(id, name, desc, date, comment);
        item.setId(id);
        tracker.update(new Item(id, name, desc, date, comment));
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Update item.");
    }
}

class DeleteItem extends BaseAction{
    public DeleteItem(String name, int key) {
        super(name, key);
    }
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
    private UserAction[] actions = new UserAction[6];
    private int position = 0;


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] range() {
        int[] rsl = new int[position]; //здесь был [position]
        int count = 0;
        for (UserAction action : this.actions) {
           // System.out.println("action: " + action );
//            System.out.println("count: " + count);
//            System.out.println("rsl" + count + ": " + rsl[count]);
//            System.out.println("action: " + action + "action.key(): " + action.key() );
            rsl[count++] = action.key();
//            System.out.println("rsl" + count + ": " +  + rsl[count-1]);
        }
        return rsl;
    }

    /*public static void test() { //mojno zakommentit
        MenuTracker tr = new MenuTracker();
        AddItem item = tr.new AddItem();
    }*/

    public void fillActions() {
        this.actions[position++] = this.new AddItem("что сюда ввести?", 0); // здесь красным из-за наследования AddItem класса BaseActions с коструктором с параметрами String name, int key
        this.actions[position++] = new MenuTracker.ShowItems("сюда тоже надо что-то передать", 0); // new ShowItems();
        this.actions[position++] = new EditItem("конструктор по умолчанию в классах нельзя создать почему-то", 0);
        this.actions[position++] = new DeleteItem();
        this.actions[position++] = this.new FindByName();
        this.actions[position++] = new MenuTracker.FindItemById();

    }

    public void addAction(UserAction action) {
        this.actions[position++] = action; //заполнение нашего массива actions[]
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

    private class AddItem extends BaseAction { //внутренний нестатический класс
        public AddItem(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.action("Введите id это запрос из AddItem класс MenuTracker");
            String name = input.action("Введите название заявки");
            String desc = input.action("Введите описание");
            String date = input.action("Введите дату");
            String comment = input.action("Введите комментарий");
            tracker.add(new Item(id, name, desc, date, comment));
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

   /* private class FindByName implements UserAction{
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            for (int i = 0; i < tracker.findByName(input.action("Enter name of items")).length ; i++) {
                System.out.println(tracker.findByName("Введите название заявки еще раз")[i]);

            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find Items by Name");
        }
    }*/

    private class FindByName extends BaseAction {
        public FindByName(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {

            for (Item item : tracker.findByName(input.action("Enter name"))) {
                System.out.println(String.format("%s. %s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getDatecreation(), item.getKomment()));
            }

        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find Items by Name");
        }
    }

    private static class ShowItems extends BaseAction{
        public ShowItems(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {

            for(Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getDatecreation(), item.getKomment()));
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    private static class FindItemById extends BaseAction {
        public FindItemById(String name, int key) {
            super(name, key);
        }
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
