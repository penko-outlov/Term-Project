package database.queries;

import database.queries.IQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Query implements IQuery {

    public final ResultSet execute(Connection connection) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(getQueryText());
            setStatementValues(statement);
            boolean returnedResultSet = statement.execute();
            if(returnedResultSet) {
                return statement.getResultSet();
            }
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return null;
    }

    protected abstract String getQueryText();
    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;
}
