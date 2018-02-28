package database.queries;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllQuery extends Query {

    private String queryText;

    public SelectAllQuery(String tableName) {
        queryText = "SELECT * FROM " + tableName;
    }

    @Override
    protected String getQueryText() { return queryText; }

    @Override
    protected void setStatementValues(PreparedStatement statement) throws SQLException {}
}
