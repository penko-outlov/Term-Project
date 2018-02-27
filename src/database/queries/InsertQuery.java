package database.queries;

import utility.StringUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class InsertQuery implements IQuery {

    String queryTemplateText;

    public InsertQuery(String tableName, String[] columnNames) {
        generateQueryText(tableName, columnNames);
    }

    private void generateQueryText(String tableName, String[] columnNames) {
        queryTemplateText = "INSERT INTO " + tableName + " " + StringUtility.CreateParenthesizedList(columnNames) + " VALUES " + StringUtility.createQuestionMarkParenthesizedList(columnNames.length);
    }

    @Override
    public PreparedStatement getPreparedStatement(Connection databaseConnection) {
        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(queryTemplateText);
            setStatementValues(statement);
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return  statement;
    }

    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;
}
