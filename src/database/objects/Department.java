package database.objects;


import database.DatabaseConnector;
import utility.StringUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Department extends TableEntry {

    public static final String ID_COLUMN_NAME = "DEPARTMENT_ID";
    public static final String TABLE_NAME = "departments";

    private int managerId;
    private String name;

    private static final String COLUMN_NAMES = "(MANAGER_ID, NAME)";

    public Department(int managerId, String name) {
        this.managerId = managerId;
        this.name = name;
    }

    @Override
    public PreparedStatement generateInsertStatement(Connection databaseConnection, String schemaName) {
        String query = "INSERT INTO " + schemaName + "." + TABLE_NAME + " " + COLUMN_NAMES + " VALUES " + StringUtility.CreateQueryParenthesizedList(2);

        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(query);
            statement.setInt(1, managerId);
            statement.setString(2, name);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }
}
