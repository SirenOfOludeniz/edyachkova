package ru.job4j.sql.magnit;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Config {
    private Connection connection;
    private final Properties properties = new Properties();

    public void init() {
        try(InputStream in = Config.class.getClassLoader()
        .getResourceAsStream("magnit.properties")){
            properties.load(in);
            Class.forName(properties.getProperty("app.driver-class-name"));
            this.connection = DriverManager.getConnection(
                    properties.getProperty("magnit.urlBaseTracker"),
                    properties.getProperty("magnit.username"),
                    properties.getProperty("magnit.password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    String get(String key) {
        return this.properties.getProperty(key);
    }
    public Connection getConnection() {
        return connection;
    }

}
