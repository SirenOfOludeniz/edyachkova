package ru.job4j.sql.magnit.storexml;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;

public class StoreXMLTest {
    public static void main(String[] args) throws JAXBException {
        File target = new File("C:\\entryFile.xml");
        StoreXML storeXML = new StoreXML(target);
        ArrayList<StoreXML.Entry> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new StoreXML.Entry(i));
        }
        storeXML.save(list);

    }
}
