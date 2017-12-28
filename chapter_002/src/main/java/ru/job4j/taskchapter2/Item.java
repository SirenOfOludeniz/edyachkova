package ru.job4j.taskchapter2;

public class Item {
    private String id;
    private String name;
    private String description;
    private String datecreation;
    private String komment;

    public Item() { }

    public Item(String id, String name, String description, String datecreation, String komment) {
        this.id = id;
        this.name = name;
        this.description = description;
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
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDatecreation() {
        return this.datecreation;
    }
    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
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
