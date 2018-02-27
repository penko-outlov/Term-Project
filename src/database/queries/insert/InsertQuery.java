package database.queries.insert;

import database.queries.IQuery;
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
    public void execute(Connection databaseConnection) {
        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(queryTemplateText);
            setStatementValues(statement);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
    }

    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;
}
