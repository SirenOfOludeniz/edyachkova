package ru.job4j.apphf;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type,
                      Wood backWood, Wood topWood, int numStrings) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;
    }

    //сравнение двух объектов GuitarSpec перенесено сюда

    public List compareGuitarSpec(GuitarSpec searchSpec) {
        Inventory inventory = new Inventory();
        List matchingGuitars = new LinkedList();
        for (Iterator i = inventory.getGuitars().iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            GuitarSpec guitarSpec = guitar.getSpec();
            if (searchSpec.getBuilder() != guitarSpec.getBuilder()) {
                continue;
            }
            String model = searchSpec.getModel().toLowerCase();
            //todo model всегда будет неравна null чего не скажешь о getModel() - тут потенциальный NPE
            //todo много много иф тут можно заменить одним условием.
            if ((model != null) && (!model.equals(""))
                    && (!model.equals(guitarSpec.getModel().toLowerCase()))) {
                continue;
            }
            if (searchSpec.getType() != guitarSpec.getType()) {
                continue;
            }
            if (searchSpec.getBackWood() != guitarSpec.getBackWood()) {
                continue;
            }
            if (searchSpec.getTopWood() != guitarSpec.getTopWood()) {
                continue;
            }
            if (searchSpec.getNumStrings() != guitarSpec.getNumStrings()) {
                continue;
            }
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }

    public boolean matches(GuitarSpec otherSpec) {
        //todo мультиретурн!  тут наверное для упрощения лучше использовать equals
        if (builder != otherSpec.builder) {
            return false;
        }
        if ((model != null) && (!model.equals(""))
                && (!model.toLowerCase().equals(otherSpec.model.toLowerCase()))) {
            return false;
        }
        if (type != otherSpec.type) {
            return false;
        }
        if (numStrings != otherSpec.numStrings) {
            return false;
        }
        if (backWood != otherSpec.backWood) {
            return false;
        }
        if (topWood != otherSpec.topWood) {
            return false;
        }
        return true;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
    public int getNumStrings() {
        return numStrings;
    }
}
