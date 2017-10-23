package ru.job4j.zayavki_moya_versiya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Zayavka {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String name = reader.readLine();
    private String Description = reader.readLine();
    private long datecreation = Integer.parseInt(reader.readLine());
   // private ArrayList<String> listkomments = new ArrayList<String>();
    private String komment = reader.readLine();

   public Zayavka() throws IOException { }

    public Zayavka(String name, String Description, long datecreation,String komment) throws IOException {
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


}
