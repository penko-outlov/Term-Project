package database.queries;

import database.queries.IQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery implements IQuery {

    private int id;
    private String sql;


    public DeleteQuery(int id, String tableName, String idColumnName) {
        this.id = id;
        sql = "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";
    }

    protected DeleteQuery(int id, String sql) {
        this.id = id;
        this.sql = sql;
    }


    @Override
    public void execute(Connection databaseConnection) {
        PreparedStatement statement = null;
        try {
            statement = databaseConnection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Failed to generate prepared statement!");
            e.printStackTrace();
        }
    }
}
