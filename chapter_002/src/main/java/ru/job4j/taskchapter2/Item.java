package ru.job4j.taskchapter2;

import java.util.Date;

public class Item {
    public static final Item EMPTY = new Item() {
        @Override
        public String toString() {
            return "Empty";
        }
    };
    private int id;
    private String name;
    private String description;
    private Date datecreation;
    private String komment;

    public Item() { }

    public Item(int id, String name, String description, Date datecreation, String komment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datecreation = datecreation;
        this.komment = komment;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", datecreation='" + datecreation + '\'' +
                ", komment='" + komment + '\'' +
                '}';
    }

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id != null ? id.equals(item.id) : item.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }*/

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
    public Date getDatecreation() {
        return this.datecreation;
    }
    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }
    public String getKomment() {
        return this.komment;
    }
    public void setKomment(String komment) {
        this.komment = komment;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
