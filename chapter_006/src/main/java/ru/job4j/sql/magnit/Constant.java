package ru.job4j.sql.magnit;

public class Constant {
    /**
     * @param URL_MAGNIT_BASE - url database -> base_tracker (from magnit.properties).
     */
    public static String URL_MAGNIT_BASE;

    /**
     * @param URL_BASE_POSTGRES - url database -> postgres (from magnit.properties).
     */
    static String URL_BASE_POSTGRES;

    /**
     * @param NAME - name user (from magnit.properties).
     */
    public static String NAME;

    /**
     * @param NAME_DATA_BASE - name database -> magnit_base (from magnit.properties).
     */
    static String NAME_DATA_BASE;

    /**
     * @param PASSWORD - password user-postgres (from magnit.properties).
     */
    public static String PASSWORD;

    public Constant(Config config) {
        URL_MAGNIT_BASE = config.getValue("magnit.urlBaseMagnit");
        URL_BASE_POSTGRES = config.getValue("magnit.urlBasePostgres");
        NAME = config.getValue("magnit.name");
        NAME_DATA_BASE = config.getValue("magnit.nameDataBase");
        PASSWORD = config.getValue("magnit.password");
    }
}
