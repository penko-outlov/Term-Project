package database.objects;


import database.TableModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Department extends TableEntry {

    public static final String ID_COLUMN_NAME = "DEPARTMENT_ID";
    public static final String TABLE_NAME = "departments";
    public static final String[] COLUMN_NAMES = { "MANAGER_ID", "NAME" };

    private static final String INSERT_QUERY = TableEntry.generateInsertQuery(TABLE_NAME, COLUMN_NAMES);
    private static final String UPDATE_QUERY = TableEntry.generateUpdateQuery(TABLE_NAME, ID_COLUMN_NAME, COLUMN_NAMES);

    private int managerId;
    private String name;

    public Department(int managerId, String name) {
        this.managerId = managerId;
        this.name = name;
    }

    @Override
    protected String getInsertQuery() {
        return INSERT_QUERY;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    protected int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setInt(1, managerId);
        statement.setString(2, name);
    }

    public int getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }





}
