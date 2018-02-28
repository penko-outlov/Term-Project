package database.queries;

import database.TableModel;
import database.queries.IQuery;
import javafx.scene.control.Tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Query implements IQuery {

    public final TableModel execute(Connection connection) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(getQueryText());
            setStatementValues(statement);
            boolean returnedResultSet = statement.execute();
            if(returnedResultSet) {
                TableModel model = createTableModel();
                model.Initialize(statement.getResultSet());
                return model;
            }
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
        return null;
    }

    protected TableModel createTableModel() {
        return new TableModel();
    }

    protected abstract String getQueryText();
    protected abstract void setStatementValues(PreparedStatement statement) throws SQLException;
}
