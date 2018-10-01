package ru.job4j.sql.magnit;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties properties = new Properties();

    public void load(InputStream io) {
        try {
            this.properties.load(io);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    String getValue(String key) {
        return this.properties.getProperty(key);
    }
}
