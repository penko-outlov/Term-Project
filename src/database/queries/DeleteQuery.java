package database.queries;

import database.queries.IQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteQuery extends Query {

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
    protected String getQueryText() {
        return sql;
    }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {
        statement.setInt(1, id);
    }
}
