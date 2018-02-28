package database.queries;

import database.queries.IQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Query implements IQuery {

    public final void execute(Connection connection) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(getQueryText());
            setStatementValues(statement);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
    }

    protected abstract String getQueryText();
    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;
}
