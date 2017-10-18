package ru.job4j.zayavki_moya_versiya;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Zayavka> bubu = new ArrayList<Zayavka>();

    Deistviya_s_zayavkoy deistviya = new Deistviya_s_zayavkoy();

    Zayavka zayavka = new Zayavka();



    public void commands(String s) throws IOException {

        if(s.equals("add")) {
            deistviya.add(zayavka, bubu);
        }
        if(s.equals("edit")) {
            deistviya.edit(zayavka);
        }
        if(s.equals("delete")) {
            deistviya.delete(zayavka);
        }
        if(s.equals("show_with_filter")) {
            deistviya.showAllWithFilter();
        }
        if(s.equals("show")) {
            deistviya.showAll();
        }
        if(s.equals("add_comment"));
    }
}
