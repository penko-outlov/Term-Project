package database.objects;

import utility.StringUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TableEntry {

    public static String generateInsertStatement(String tableName, String columnNames, int numColumns) {
        return "INSERT INTO " + tableName + " " + columnNames + " VALUES " + StringUtility.CreateQueryParenthesizedList(numColumns);
    }

    public final PreparedStatement generateInsertStatement(Connection databaseConnection) {
        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(getInsertQuery());
            setStatementValues(statement);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }

    protected abstract String getInsertQuery();

    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;

    //public abstract PreparedStatement generateUpdateStatement(Connection databaseConnection, String schemaName, int id);
}
