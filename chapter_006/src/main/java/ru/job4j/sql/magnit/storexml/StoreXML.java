package ru.job4j.sql.magnit.storexml;

import ru.job4j.sql.magnit.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreXML {
    File target;


    public StoreXML(File target) {
        this.target = target;
    }


    /**
     * this method save Data in File from List
     * @param list
     */
    public void save(List<Entry> list) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                new Entries(Arrays.asList(new Entry(1), new Entry(2))),
                target
        );
    }

    @XmlRootElement
    public static class Entries {
        private List<Entry> entries;
        public Entries() {

        }
        public Entries(List<Entry> entries) {
            this.entries = entries;
        }

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }
    }
    @XmlRootElement
    public static class Entry {
        private int field;
        public Entry() {

        }
        public Entry(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }
    }
}
