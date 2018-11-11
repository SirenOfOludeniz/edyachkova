package ru.job4j.taskchapter2;

public class Constant {
    private static Settings settings;
    /**
     * @param URL_BASE_TRACKER - url database -> base_tracker (from app.properties).
     */
    public static final String URL_BASE_TRACKER = settings.getValue("app.urlBaseTracker");

    /**
     * @param URL_BASE_POSTGRES - url database -> postgres (from app.properties).
     */
    public static final String URL_BASE_POSTGRES = settings.getValue("app.urlBasePostgres");

    /**
     * @param NAME - name user (from app.properties).
     */
    public static final String NAME = settings.getValue("app.name");

    /**
     * @param NAME_DATA_BASE - name database -> base_tracker (from app.properties).
     */
   public static final String NAME_DATA_BASE = settings.getValue("app.nameDataBase");

    /**
     * @param PASSWORD - password user-postgres (from app.properties).
     */
    public static final String PASSWORD = settings.getValue("app.password");

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static final String ADD_ITEM = settings.getValue("app.addItem");

    /**
     * @param SEARCH_ITEM_BY_ID - query sql: search item by id (from app.properties).
     */
    public static final String SEARCH_ITEM_BY_ID = settings.getValue("app.searchItemById");

    /**
     * @param UPDATE_ITEM_BY_ID - query sql: update item by id (from app.properties).
     */
    public static final String UPDATE_ITEM_BY_ID = settings.getValue("app.updateItemById");

    /**
     * @param REMOVE_ITEM_BY_ID - query sql: remove item by id (from app.properties).
     */
    public static final String REMOVE_ITEM_BY_ID = settings.getValue("app.removeItemById");

    /**
     * @param GET_ALL_ITEM - query sql: get all item (from app.properties).
     */
    public static final String GET_ALL_ITEM = settings.getValue("app.getAllItem");

    /**
     * @param ADD_COMMENT_BY_ID - query sql: add comment by id (from app.properties).
     */
    public static final String ADD_COMMENT_BY_ID = settings.getValue("app.addCommentById");

    /**
     * @param SEARCH_COMMENT_BY_ITEM_ID - query sql: search comment by item id (from app.properties).
     */
    public static final String SEARCH_COMMENT_BY_ITEM_ID = settings.getValue("app.searchCommentByItemId");

    /**
     * @param SEARCH_DATA_BASE - query sql: search database -> base_tracker (from app.properties).
     */
   private static final String SEARCH_DATA_BASE = settings.getValue("app.searchDataBase");

    /**
     * @param SEARCH_TABLE - query sql: search table -> item (from app.properties).
     */
    static final String SEARCH_TABLE = settings.getValue("app.searchTable");

    /**
     * @param CREATE_DATA_BASE - query sql: create database -> base_tracker (from app.properties).
     */
    static final String CREATE_DATA_BASE = settings.getValue("app.createDataBase");

    /**
     * @param CREATE_TABLE_ITEM - query sql: create table item (from app.properties).
     */
    static final String CREATE_TABLE_ITEM = settings.getValue("app.createTableItem");

    /**
     * @param CREATE_TABLE_COMMENTS - query sql: create table comments (from app.properties).
     */
    static final String CREATE_TABLE_COMMENTS = settings.getValue("app.createTableComments");

    /**
     * Constant - constructor (reads all parameters from file app.properties).
     * @param settings - link to object of class Setting.
     */
    public Constant(Settings settings) {
        this.settings = settings;
    }
}
