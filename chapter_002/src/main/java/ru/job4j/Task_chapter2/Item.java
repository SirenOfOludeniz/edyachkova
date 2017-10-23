package ru.job4j.Task_chapter2;

public class Item {
    private String id;
    private String name;
    private String Description;
    private long datecreation;
    private String komment;

    public Item() { }

    public Item(String id, String name, String Description, long datecreation,String komment) {
        this.id = id;
        this.name = name;
        this.Description = Description;
        this.datecreation = datecreation;
        this.komment = komment;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public  String getDescription() {
        return this.Description;
    }
    public void setDescription(String Descripton) {
        this.Description = Descripton;
    }
    public long getDatecreation() {
        return this.datecreation;
    }
    public void setDatecreation(long Datecreation) {
        this.datecreation = Datecreation;
    }
    public String getKomment() {
        return this.komment;
    }
    public void setKomment(String komment) {
        this.komment = komment;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
