package database.objects;


import database.DatabaseConnector;
import utility.StringUtility;

import javax.xml.validation.Schema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Department extends TableEntry {

    public static final String ID_COLUMN_NAME = "DEPARTMENT_ID";
    public static final String TABLE_NAME = "departments";

    private int managerId;
    private String name;

    private static final String COLUMN_NAMES = "(MANAGER_ID, NAME)";
    private static final String INSERT_STATEMENT = "INSERT INTO " + TABLE_NAME + " " + COLUMN_NAMES + " VALUES " + StringUtility.CreateQueryParenthesizedList(2);

    public Department(int managerId, String name) {
        this.managerId = managerId;
        this.name = name;
    }

    @Override
    public PreparedStatement generateInsertStatement(Connection databaseConnection) {
        String query = "INSERT INTO " + TABLE_NAME + " " + COLUMN_NAMES + " VALUES " + StringUtility.CreateQueryParenthesizedList(2);

        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(query);
            setStatementValues(statement);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }

    /*
    @Override
    public PreparedStatement generateUpdateStatement(Connection databaseConnection, String schemaName, int id) {
        String query = "UPDATE " + schemaName + "." + TABLE_NAME + " SET " +;

        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(query);
            setStatementValues(statement);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }
    */

    private void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setInt(1, managerId);
        statement.setString(2, name);
    }



}
