package ru.job4j.zayavki_moya_versiya;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Deistviya_s_zayavkoy {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Zayavka> listzayz = new ArrayList<Zayavka>();

     //я могу создать поле массив Аррейлист и туда перезаписать элементы из adddzayavka

    public ArrayList<Zayavka> add(Zayavka zayavka, ArrayList<Zayavka> zl) {

        zl.add(zayavka);

        return zl ;
    }

    public Zayavka edit(Zayavka zayavka) throws IOException {

        zayavka.setName(reader.readLine());
        zayavka.setDatecreation(Long.parseLong(reader.readLine()));
        zayavka.setDescription(reader.readLine());
        zayavka.setKomment(reader.readLine());

        return zayavka;
    }

    public Zayavka delete(Zayavka zayavka) {
        zayavka = null;
        return zayavka;
    }

    public ArrayList<Zayavka> showAll() {
        return listzayz;
    }

    public ArrayList<Zayavka> showAllWithFilter() {
        return listzayz;
    }

    public String addkomment(Zayavka zayavka) throws IOException {
        zayavka.setKomment(reader.readLine());
        return zayavka.getKomment();
    }

}
