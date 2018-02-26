package database.objects;

import utility.StringUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TableEntry {

    protected static String generateInsertQuery(String tableName, String[] columnNames) {
        return "INSERT INTO " + tableName + " " + StringUtility.CreateParenthesizedList(columnNames) + " VALUES " + StringUtility.createQuestionMarkParenthesizedList(columnNames.length);
    }

    protected static String generateUpdateQuery(String tableName, String idColumnName, String[] columnNames) {
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE "); builder.append(tableName);
        builder.append(" SET " ); builder.append(StringUtility.createSqlStatementColumnList(columnNames));
        builder.append(" WHERE "); builder.append(idColumnName); builder.append(" = ? ");
        return builder.toString();
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

    public  final PreparedStatement generateUpdateStatement(Connection databaseConnection, int id) {
        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(getUpdateQuery());
            setStatementValues(statement);
            statement.setInt(getColumnCount() + 1, id);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }

    protected abstract String getUpdateQuery();

    protected abstract int getColumnCount();

    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;

    //TODO : Allow passing of null for table entry values. If a value is null, update statements don't change it
}
